package com.guhecloud.rudez.npmarket.http;

/**
 * 网络请求常量类
 */
public class ConstantParser {
    // 接口前面部分
    public static final String HTTP_URI = "http://132.232.11.106:8182/";
//    public static final String HTTP_URI = "http://192.168.30.45:8182/";

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
    //采价查询商品
    public static final String GETPRICEGOODS = "price/getOffer";
    //根据采价任务查商品
    public static final String GETPRICEGOODSBYTASK = "price/getPriceTaskGoods";
    //根据商品查商家
    public static final String GETMERCHANTBYGOODS = "price/getCustByOffer";
    //采价
    public static final String COLLECTPRICE = "price/addPrice";
    //获取区县
    public static final String GETAREA = "area/area";
    //获取地市
    public static final String GETCITY = "area/city";
    //获取省级单位
    public static final String GETPROVINCE = "area/province";
    //上传图片
    public static final String UPLOAD = "file/upload";
    //获取未读消息数量
    public static final String GETMSGCOUNT = "message/getMessageCount";
    //获取通知公告列表
    public static final String GETMSGNOTICE = "message/getNoticeByUser";
    //获取待办列表
    public static final String GETMSGTOCO = "message/getUserTodoList";
    //获取预警提醒列表
    public static final String GETMSGWARNING = "message/getWarningList";

}