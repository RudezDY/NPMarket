package com.guhecloud.rudez.npmarket.http;


import android.text.TextUtils;

import org.xutils.http.HttpMethod;

import java.util.HashMap;
import java.util.List;
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
     * @param loginName
     * @param password
     * @param callBack
     */
    public static void login(String loginName,String password,
                                HttpCallBack callBack) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginName",loginName);
        map.put("password",password);
        HttpRequestUtil.sendJson( HttpMethod.POST, ConstantParser.LOGIN,
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

    /**
     * 搜索商品
     * @param curPage
     * @param pageSize
     * @param keyWord
     * @param callBack
     */
    public static void searchGoods(int curPage,int pageSize,String keyWord,
                                 HttpCallBack callBack) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("curPage",curPage);
        map.put("pageSize",pageSize);
        map.put("keyWord",keyWord);
        HttpRequestUtil.sendJson( HttpMethod.POST, ConstantParser.SEARCH_GOODS,
                map, callBack);
    }

    /**
     * 商品详情
     * @param offerId
     * @param callBack
     */
    public static void getGoodsDetails(String offerId,
                                     HttpCallBack callBack) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("offerId",offerId);
        HttpRequestUtil.send( HttpMethod.GET, ConstantParser.GOODS_DETAILS,
                map, callBack);
    }


    /**
     * 首页
     * @param callBack
     */
    public static void getHomePage(
                                          HttpCallBack callBack) {
        Map<String, Object> map = new HashMap<String, Object>();
        HttpRequestUtil.send( HttpMethod.GET, ConstantParser.HOMEPAGE,
                map, callBack);
    }


    /**
     * 获取应用信息
     * @param callBack
     */
    public static void getAppletInfo(
                                          HttpCallBack callBack) {
        Map<String, Object> map = new HashMap<String, Object>();
        HttpRequestUtil.send( HttpMethod.GET, ConstantParser.GETAPPLETINFO,
                map, callBack);
    }

    /**
     * 保存应用信息
     * @param applicationList
     * @param callBack
     */
    public static void saveAppletInfo(List<Integer> applicationList,
                                          HttpCallBack callBack) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("applicationList",applicationList);
        HttpRequestUtil.sendJson( HttpMethod.POST, ConstantParser.SAVEAPPLETINFO,
                map, callBack);
    }


    /**
     * 获取市场行情，
     * @param startDate
     * @param endDate
     * @param callBack
     */
    public static void getMarketPrice(String startDate,String endDate,
                                          HttpCallBack callBack) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (TextUtils.isEmpty(startDate) || TextUtils.isEmpty(endDate)) {

        }else {
            map.put("startDate",startDate);
            map.put("endDate",endDate);
        }
        HttpRequestUtil.sendJson( HttpMethod.POST, ConstantParser.MARKETPRICE,
                map, callBack);
    }


    /**
     * 获取可选时段
     * @param callBack
     */
    public static void getWeekList(
                                          HttpCallBack callBack) {
        Map<String, Object> map = new HashMap<String, Object>();
        HttpRequestUtil.send( HttpMethod.GET, ConstantParser.GETTIMEFRAME,
                map, callBack);
    }


    /**
     *
     * @param applyDateFrom 开始时间
     * @param applyDateTo 结束时间
     * @param offerType 商品分类
     * @param search 搜索关键字
     * @param curPage 当前页
     * @param pageSize
     * @param callBack
     */
    public static void getPriceRecord(int curPage,int pageSize,String applyDateFrom,String applyDateTo,String offerType,
                                          String search,
                                          HttpCallBack callBack) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("curPage",curPage);
        map.put("pageSize",pageSize);
        if (!TextUtils.isEmpty(applyDateFrom)&&!TextUtils.isEmpty(applyDateTo)){
            map.put("applyDateFrom",applyDateFrom);
            map.put("applyDateTo",applyDateTo);
        }
        if (!TextUtils.isEmpty(offerType)){
            map.put("offerType",offerType);
        }
        if (!TextUtils.isEmpty(search)){
            map.put("search",search);
        }

        HttpRequestUtil.sendJson( HttpMethod.POST, ConstantParser.GETPRICERECORD,
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