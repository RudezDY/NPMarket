package com.guhecloud.rudez.npmarket.mvp.model;

import java.util.List;

/**
 * Created by homework on 2019/4/25.
 */

public class CoPriSearchObj {
    /**
     * records : [{"offerId":"01010101","offerName":"大白花土豆","unit":"元/斤"},{"offerId":"01010102","offerName":"新鲜土豆","unit":"元/斤"},{"offerId":"01010103","offerName":"菜土豆","unit":"元/斤"}]
     * total : 3
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
    public List<Record> records;

    public static class Record {
        /**
         * offerId : 01010101
         * offerName : 大白花土豆
         * unit : 元/斤
         */

        public String offerId;
        public String offerName;
        public String unit;
        public String custId;
        public String custName;
        public int count;
    }


}
