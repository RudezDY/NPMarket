package com.guhecloud.rudez.npmarket.http;


import org.xutils.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Donghui 网络请求方法类
 */
public class HttpUtil {

    /**
     * 获取部门列表
     * @param callBack
     */
    public static void getDept(HttpCallBack callBack) {
        Map<String, Object> map = new HashMap<String, Object>();
        HttpRequestUtil.send( HttpMethod.GET, ConstantParser.GETDEPT,
                map, callBack);
    }

    /**
     * 获取通讯录
     * @param deptId
     * @param keyWord
     * @param callBack
     */
    public static void getBook(String deptId,String keyWord,HttpCallBack callBack) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("deptId",deptId);
        map.put("keyWord",keyWord);
        HttpRequestUtil.sendJson( HttpMethod.GET, ConstantParser.GETBOOK,
                map, callBack);
    }

    /**
     * 登录
     * @param userName
     * @param password
     * @param callBack
     */
    public static void login(String userName,String password,
                                HttpCallBack callBack) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName",userName);
        map.put("password",password);
        HttpRequestUtil.send( HttpMethod.POST, ConstantParser.LOGIN,
                map, callBack);
    }

    /**
     * 获取搜索历史
     * @param callBack
     */
    public static void getSearchHistory(HttpCallBack callBack){
        Map<String, Object> map = new HashMap<String, Object>();
        HttpRequestUtil.send( HttpMethod.GET, ConstantParser.GETSEARCHHISTORY,
                map, callBack);
    }

    /**
     * 清空搜索历史
     * @param callBack
     */
    public static void clearSearchHistory(HttpCallBack callBack){
        Map<String, Object> map = new HashMap<String, Object>();
        HttpRequestUtil.send( HttpMethod.POST, ConstantParser.CLEARSEARCHHISTORY,
                map, callBack);
    }

    /**
     * 搜索客户
     * @param curPage
     * @param pageSize
     * @param keyWord
     * @param callBack
     */
    public static void searchMerchant(int curPage,int pageSize,String keyWord,
                                      HttpCallBack callBack) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("curPage",curPage);
        map.put("pageSize",pageSize);
        map.put("keyWord",keyWord);
        HttpRequestUtil.sendJson( HttpMethod.POST, ConstantParser.SEARCH_MERCHANT,
                map, callBack);
    }

    /**
     * 商户详情
     * @param id
     * @param callBack
     */
    public static void getMerchantDetails(int id,
                                      HttpCallBack callBack) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id",id);
        HttpRequestUtil.send( HttpMethod.GET, ConstantParser.MERCHANT_DETAILS,
                map, callBack);
    }

    /**
     * 搜索车辆
     * @param curPage
     * @param pageSize
     * @param keyWord
     * @param callBack
     */
    public static void searchCar(int curPage,int pageSize,String keyWord,
                                      HttpCallBack callBack) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("curPage",curPage);
        map.put("pageSize",pageSize);
        map.put("keyWord",keyWord);
        HttpRequestUtil.sendJson( HttpMethod.POST, ConstantParser.SEARCH_CAR,
                map, callBack);
    }

    /**
     * 车辆详情
     * @param id
     * @param callBack
     */
    public static void getCarDetails(int id,
                                          HttpCallBack callBack) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id",id);
        HttpRequestUtil.send( HttpMethod.GET, ConstantParser.CAR_DETAILS,
                map, callBack);
    }


//    /**
//     * 上传图片
//     * @param imgs
//     * @param callBack
//     */
//    public static void uoLoadImg(List<File> imgs,
//                                HttpCallBack callBack) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        for (int i=0;i<imgs.size();i++){
//            File img=imgs.get(i);
//            map.put("img["+i+"]",img);
//        }
//        map.put("token", User.getInstance().token);
//        HttpRequestUtil.send("上传图片", HttpMethod.POST, ConstantParser.UPLOADIMG,
//                map, callBack);
//    }















}