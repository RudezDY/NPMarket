package com.guhecloud.rudez.npmarket.di.module;



import com.google.gson.Gson;
import com.guhecloud.rudez.npmarket.BuildConfig;
import com.guhecloud.rudez.npmarket.commonmodel.Constants;
import com.guhecloud.rudez.npmarket.commonmodel.http.HttpHelper;
import com.guhecloud.rudez.npmarket.commonmodel.http.api.HaveCacheApis;
import com.guhecloud.rudez.npmarket.commonmodel.http.api.NoCacheHttpApis;
import com.guhecloud.rudez.npmarket.di.qualifier.HaveCache;
import com.guhecloud.rudez.npmarket.di.qualifier.NoCache;
import com.guhecloud.rudez.npmarket.util.LogUtil;
import com.guhecloud.rudez.npmarket.util.SignUtil;
import com.guhecloud.rudez.npmarket.util.SystemUtil;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Chanin on 2017/6/14.
 */
@Module
public class HttpModule {

    @Provides
    @Singleton
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Provides
    @Singleton
    @HaveCache
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Provides
    @Singleton
    @NoCache
    OkHttpClient.Builder provideNoCacheOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Provides
    @Singleton
    @HaveCache
    OkHttpClient provideCacheOkHttpClient(@HaveCache OkHttpClient.Builder builder) {
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }

        File cacheFile = new File(Constants.PATH_HTTP_CACHE);
        if(!cacheFile.exists()){
            cacheFile.mkdirs();
        }

        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                if (SystemUtil.isNetworkConnected()) {
                    int maxAge = 0;
                   response = response.newBuilder().header("Cache-Control", "public,max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();

                } else {
                    int maxStale = 60 * 60 * 24 * 28;
                   response =  response.newBuilder()
                            .header("Cache-Control", "public,only-if-cached,max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();

                }
                LogUtil.d("cacheInterceptor");
                return response;
            }
        };

        final Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!SystemUtil.isNetworkConnected()) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                LogUtil.d("interceptor");
                return chain.proceed(request);
            }
        };
        if (Constants.SIGN) {
            addSign(builder);
        }


        builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(interceptor);
        builder.cache(cache);
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }

    private void addSign(OkHttpClient.Builder builder) {
        Interceptor paramInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                RequestBody body = request.body();
                HashMap<String, String> hashMap = new HashMap<>();
                String method = request.method();
                if ("GET".equals(method)) {
                    HttpUrl url = request.url();
                    int i = url.querySize();
                    if (i > 0) {
                        for (int j = 0; j < i; j++) {
                            hashMap.put(url.queryParameterName(j), url.queryParameterValue(j));
                        }
                    }
                } else {

                    if (body instanceof FormBody) {
                        FormBody formBody = (FormBody) body;
                        int size = formBody.size();
                        if (size > 0) {
                            for (int i = 0; i < size; i++) {
                                hashMap.put(formBody.name(i), formBody.value(i));
                            }
                        }
                    } else if (body instanceof MultipartBody) {
                        MultipartBody multipartBody = (MultipartBody) body;
                        List<MultipartBody.Part> parts = multipartBody.parts();
                        LogUtil.d( new Gson().toJson(parts));
                    }

                }
                long rndo = System.currentTimeMillis();
//                hashMap.put("rndo", rndo + "");

                String sign = SignUtil.signParams(hashMap);
//                hashMap.put("sign", sign);
                LogUtil.d( "params" + new Gson().toJson(hashMap));

                if ("GET".equals(method)) {
                    StringBuilder sb = new StringBuilder(request.url().host());
                    Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
                    sb.append("?");
                    while (it.hasNext()) {
                        Map.Entry<String, String> next = it.next();
                        sb.append(next.getKey()).append("=").append(next.getValue()).append("&");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    request = request.newBuilder().url(sb.toString()).build();
                } else {
                    if ("POST".equals(method)) {
                        if (!(body instanceof MultipartBody)) {
                            FormBody.Builder bodyBuilder = new FormBody.Builder();
                            Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
                            while (it.hasNext()) {
                                Map.Entry<String, String> next = it.next();
                                String key = next.getKey();
                                String value = next.getValue();
                                bodyBuilder.add(key, value);
                            }
                            request = request.newBuilder().method(method, bodyBuilder.build()).build();
                        }
                    }
                }

                return chain.proceed(request);
            }
        };
        builder.addInterceptor(paramInterceptor);
    }


    @Provides
    @Singleton
    @NoCache
    OkHttpClient provideNoCacheOkHttpClient(@NoCache OkHttpClient.Builder builder) {
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                if(SystemUtil.isNetworkConnected()){
                    return chain.proceed(chain.request());
                }
                return null;
            }
        });

        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
       // builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);
        if(Constants.SIGN){
            addSign(builder);
        }
        return builder.build();
    }

    @Provides
    @Singleton
    @HaveCache
    Retrofit createCacheRetrofit(Retrofit.Builder builder, @HaveCache OkHttpClient client) {
        return createRetrofit(builder, client, HaveCacheApis.HOST);
    }

    @Provides
    @Singleton
    @NoCache
    Retrofit createNoCacheRetrofit(Retrofit.Builder builder, @NoCache OkHttpClient client) {
        return createRetrofit(builder, client, NoCacheHttpApis.HOST);
    }


    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    NoCacheHttpApis provideNoCacheHttpApis(@NoCache Retrofit retrofit) {
        return retrofit.create(NoCacheHttpApis.class);
    }

    @Provides
    @Singleton
    HaveCacheApis provideHaveCacheHttpApis(@HaveCache Retrofit retrofit) {
        return retrofit.create(HaveCacheApis.class);
    }


    @Provides
    @Singleton
    HttpHelper provideHttpHelper(HaveCacheApis haveCacheApis, NoCacheHttpApis noCacheHttpApis) {
        return new HttpHelper(haveCacheApis, noCacheHttpApis);
    }


}
