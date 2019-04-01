package com.guhecloud.rudez.npmarket.commonmodel.http.api;


import com.guhecloud.rudez.npmarket.commonmodel.http.response.ResultMessage;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Chanin on 2017-07-04.
 */
public interface NoCacheHttpApis {

//     String HOST = "http://192.168.10.123:8080/jwxzs/data/";

     String HOST =  "http://yapi.demo.qunar.com/mock/58008/";



     //登录
     @FormUrlEncoded
     @POST("data/login")
     Flowable<ResultMessage> login(@Field("name") String name, @Field("password") String password);

     //测试
     @FormUrlEncoded
     @POST("data/register")
     Flowable<ResultMessage> register(@Field("name") String name, @Field("password") String password);

}