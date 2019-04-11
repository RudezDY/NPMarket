package com.guhecloud.rudez.npmarket.commonmodel.http.api;


import com.guhecloud.rudez.npmarket.commonmodel.http.response.ResultMessage;

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

//     String HOST = "http://192.168.10.123:8080/jwxzs/data/";

//     String HOST =  "http://yapi.demo.qunar.com/mock/58008/";
     String token="1MsREf4oMTznc7JJwdN5PC3cDSULGdd6s6rJru2++qGvhhXa/5Too9viCFQiyeV9vgGIdR6UYFO8DlQqT/N1fRzR20bCx9FcEMNzsrRsboGJWcBNYJPWR4AFaJ7RGcgS8U2cRhUQS1WI9nsPT/XcYjNbcdQQsy+NMIdScldijp8=";

     String HOST =  "http://39.97.164.154:8182/";


     //登录
     @FormUrlEncoded
     @POST("userLogin")
     Flowable<ResultMessage> login(@Field("userName") String name, @Field("password") String password);

     //登录

     @GET("login")
     Flowable<ResultMessage> tokenLogin(@Header("token") String token);

//     //测试
//     @FormUrlEncoded
//     @POST("data/register")
//     Flowable<ResultMessage> register(@Field("name") String name, @Field("password") String password);

}