package com.guhecloud.rudez.npmarket.mvp.model;

import java.util.List;

/**
 * Created by homework on 2019/4/22.
 */

public class GoodsListObj {

    /**
     * records : [{"id":1,"offerId":"01010101","offerName":"大白花土豆","custId":"01","custName":"客户01"},{"id":2,"offerId":"01010103","offerName":"菜土豆","custId":"01","custName":"客户01"}]
     * total : 2
     * size : 10
     * current : 1
     * searchCount : true
     * pages : 1
     */

    public int total;
    public int size;
    public int current;
    public boolean searchCount;
    public int pages;
    public List<GoodsObj> records;

    public static class GoodsObj {
        /**
         * id : 1
         * offerId : 01010101
         * offerName : 大白花土豆
         * custId : 01
         * custName : 客户01
         */

        public int id;
        public String offerId;
        public String offerName;
        public String offerAlias;
        public String custId;
        public String custName;
    }
}
