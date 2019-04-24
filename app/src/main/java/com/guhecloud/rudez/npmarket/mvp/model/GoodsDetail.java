package com.guhecloud.rudez.npmarket.mvp.model;

/**
 * Created by homework on 2019/4/22.
 */

public class GoodsDetail{


    /**
     * id : 1
     * offerId : 01010101
     * offerName : 大白花土豆
     * offerAlias : null
     * custId : 01
     * custName : 客户01
     * shopStallsName : 档位01,档位02
     * feeH : 6.3
     * unit : 元/千克
     * offerCustBehDTO : {"id":1,"dateNo":20190415,"monthNo":201904,"custId":"01","custName":"客户01","offerId":"01010101","enterTime":"2019-04-18 22:53:51","enterNumber":5.22,"unit":"公斤","productArea":"成都双流","mgArea":"成都"}
     */

    public int id;
    public String offerId;
    public String offerName;
    public String offerAlias;
    public String offerType;
    public String custId;
    public String custName;
    public String shopStallsName;
    public double feeH;
    public String unit;
    public CustDTO offerCustBehDTO;

    public static class CustDTO {
        /**
         * id : 1
         * dateNo : 20190415
         * monthNo : 201904
         * custId : 01
         * custName : 客户01
         * offerId : 01010101
         * enterTime : 2019-04-18 22:53:51
         * enterNumber : 5.22
         * unit : 公斤
         * productArea : 成都双流
         * mgArea : 成都
         */

        public int id;
        public int dateNo;
        public int monthNo;
        public String custId;
        public String custName;
        public String offerId;
        public String enterTime;
        public double enterNumber;
        public String unit;
        public String productArea;
        public String mgArea;
    }
}
