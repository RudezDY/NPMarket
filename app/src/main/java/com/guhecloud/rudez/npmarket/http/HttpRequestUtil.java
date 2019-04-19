package com.guhecloud.rudez.npmarket.http;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.app.App;
import com.guhecloud.rudez.npmarket.mvp.model.User;
import com.guhecloud.rudez.npmarket.util.LoadingDialogUtil;
import com.guhecloud.rudez.npmarket.util.LogUtil;
import com.guhecloud.rudez.npmarket.util.SystemUtil;
import com.guhecloud.rudez.npmarket.util.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.util.Map;


/**
 * Created by donghui on 2017/5/25.网络请求工具类，基于xutil3.0
 */
public class HttpRequestUtil {
    public static final String URL = "";
    static HttpCallBack mHttpCallBack;
    /**
     * 发送请求
     *
     * @param method
     *            请求类型 Post或Get
     * @param url
     *            请求地址
     * @param map
     *            请求参数
     * @param mHttpCallBack
     *            回调接口
     */
    public static void send(HttpMethod method,
                            String url, Map<String, Object> map, HttpCallBack mHttpCallBack) {
        HttpRequestUtil.mHttpCallBack=mHttpCallBack;

        url = ConstantParser.HTTP_URI + url;
        Log.i("url", url);
        RequestParams params=parserMap(method,url, map);
        if (!TextUtils.isEmpty(User.getInstance().token)){
            params.addHeader("token",User.getInstance().token);
            Log.d("token",User.getInstance().token);
        }
        params.setConnectTimeout(8000);
        if (method== HttpMethod.POST){
            x.http().post(params,callback);
        }
        else if (method== HttpMethod.GET){
            x.http().get(params,callback);
        }
        LoadingDialogUtil.createLoadingDialog(App.getInstance().mCurrentActivity.get()
                ,R.layout.loading_default,true).show();

    }


    /**
     * 解析map集合 并封装到RequestParams对象
     *
     * @param map
     * @return
     */
    private static RequestParams parserMap(HttpMethod method, String url,
                                           Map<String, Object> map) {
        // 设置请求参数
        RequestParams params = new RequestParams(url);
        if (map == null || map.size() <= 0) {
            return params;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Log.i("params","key= " + entry.getKey() + " and value= "
                    + entry.getValue());
            if (entry.getValue() instanceof File) {
                params.addBodyParameter(entry.getKey(),
                        (File) entry.getValue());
            } else if (method== HttpMethod.POST) {
                params.addBodyParameter(entry.getKey(), entry.getValue() + "");
            } else if (method== HttpMethod.GET) {
                params.addQueryStringParameter(entry.getKey(), entry.getValue()
                        + "");
            }
        }
        return params;
    }


    /**
     * xutil的网络请求回调
     */
    public static Callback.CommonCallback<String> callback=new Callback.CommonCallback<String>(){
        @Override
        public void onSuccess(String result) {
            if (TextUtils.isEmpty(result))
                return;
            LogUtil.i(result);
            AutoResult autoResult = new Gson().fromJson(result,AutoResult.class);
            if (AutoResult.SUCCESS == autoResult.code && null!=autoResult.data)
                mHttpCallBack.onSuccess(new Gson().toJson(autoResult.data));
            else
                mHttpCallBack.onSuccess(autoResult.msg);

        }

        @Override
        public void onError(Throwable ex, boolean isOnCallback) {
            mHttpCallBack.onFailure(ex.toString()+"      isOnCallback:"+isOnCallback);
            ToastUtil.show("网络请求异常");
            LogUtil.e(ex.getMessage());
        }

        @Override
        public void onCancelled(CancelledException cex) {
            mHttpCallBack.onFailure(cex.toString()+  "请求取消");
            ToastUtil.show(cex.toString()+  "请求取消");
        }

        @Override
        public void onFinished() {//成功或失败都会调用此方法
            LoadingDialogUtil.closeLoadingDialog();
        }
    };


    /**
     * 上传图片（加请求头）
     */

    public static void upload(HttpMethod method,
                              String url, Map<String, Object> map, HttpCallBack mHttpCallBack) {
        HttpRequestUtil.mHttpCallBack=mHttpCallBack;

        url = ConstantParser.HTTP_URI + url;
        Log.i("url", url);
        RequestParams params=parserMap(method,url, map);
        params.setMultipart(true);
        params.addHeader("Content-Type", "multipart/form-data");
        if (method== HttpMethod.POST){
            x.http().post(params,callback);
        }
        else if (method== HttpMethod.GET){
            x.http().get(params,callback);
        }

    }


    public static void sendJson(HttpMethod method,
                                String url,Map<String, Object> map, HttpCallBack mHttpCallBack) {
        HttpRequestUtil.mHttpCallBack=mHttpCallBack;

        url = ConstantParser.HTTP_URI + url;
        Log.i("url", url);
        RequestParams params=new RequestParams(url);
        if (!TextUtils.isEmpty(User.getInstance().token)){
            params.addHeader("token",User.getInstance().token);
            Log.d("token",User.getInstance().token);
        }
        params.setConnectTimeout(8000);

        JSONObject js_request = new JSONObject();//服务器需要传参的json对象
        try {
            for (Map.Entry<String,Object> entry : map.entrySet()){
                js_request.put(entry.getKey(),entry.getValue());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        params.setAsJsonContent(true);
        params.setBodyContent(js_request.toString());
        x.http().post(params,callback);
        String name = SystemUtil.getRunningActivityName(App.getInstance().getApplicationContext());
        LogUtil.i("我怎么这么好看："+name);
        LoadingDialogUtil.createLoadingDialog(App.getInstance().mCurrentActivity.get(), R.layout.loading_default,true).show();
    }


}
