package com.guhecloud.rudez.npmarket.http;

/**
 * 网络请求常量类
 */
public class ConstantParser {
    // 接口前面部分
    public static final String HTTP_URI = "http://132.232.11.106:8182/";

    //获取部门
    public static final String GETDEPT = "address/dept";
    //获取联系人
    public static final String GETBOOK = "address/book";
    //登录
    public static final String LOGIN = "userLogin";
    //搜索历史
    public static final String GETSEARCHHISTORY = "search/getSearchHistory";
    //清空搜索历史
    public static final String CLEARSEARCHHISTORY = "search/deleteSearchHistory";
    //搜索用户
    public static final String SEARCH_MERCHANT = "cust/search";
    //用户详情
    public static final String MERCHANT_DETAILS = "cust/detail";
    //搜索商品
    public static final String SEARCH_GOODS = "offer/search";
    //商品详情
    public static final String GOODS_DETAILS = "offer/detail";
    //搜索车辆
    public static final String SEARCH_CAR = "car/search";
    //车辆详情
    public static final String CAR_DETAILS = "car/detail";
    //首页
    public static final String HOMEPAGE = "index";
    //获取应用信息
    public static final String GETAPPLETINFO = "index/app/all";
    //保存应用信息
    public static final String SAVEAPPLETINFO = "index/app/update";
    //市场行情
    public static final String MARKETPRICE = "price/getPriceInfoByWeek";
    //可选时段
    public static final String GETTIMEFRAME = "price/getWeekList";
    //采价记录
    public static final String GETPRICERECORD = "price/getPriceList";

}