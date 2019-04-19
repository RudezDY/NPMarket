package com.guhecloud.rudez.npmarket.commonmodel.http.api;


import com.guhecloud.rudez.npmarket.commonmodel.http.response.ResultMessage;
import com.guhecloud.rudez.npmarket.mvp.model.User;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Chanin on 2017-07-04.
 */
public interface NoCacheHttpApis {


     String HOST =  "http://132.232.11.106:8182/";


     //登录
     @FormUrlEncoded
     @POST("userLogin")
     Flowable<ResultMessage<User>> login(@Field("userName") String name, @Field("password") String password);

     //登录

     @GET("login")
     Flowable<ResultMessage> tokenLogin(@Header("token") String token);

     //联系人
     @FormUrlEncoded
     @POST("address/book")
     Flowable<ResultMessage> getConstants(@Header("token") String token,@Field("queryDTO")String queryDTO);

     //联系人部门
     @GET("address/dept")
     Flowable<ResultMessage> getDept(@Header("token") String token);

//     //测试
//     @FormUrlEncoded
//     @POST("data/register")
//     Flowable<ResultMessage> register(@Field("name") String name, @Field("password") String password);

}