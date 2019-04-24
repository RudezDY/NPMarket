package com.guhecloud.rudez.npmarket.mvp.model;

import java.util.List;

/**
 * Created by homework on 2019/4/22.
 */

public class CarListObj {

    /**
     * records : [{"id":1,"code":"51390298805267894","name":"51390298805267894","carTypeId":1,"carTypeName":"轿车"}]
     * total : 1
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
    public List<CarObj> records;

    public static class CarObj {
        /**
         * id : 1
         * code : 51390298805267894
         * name : 51390298805267894
         * carTypeId : 1
         * carTypeName : 轿车
         */

        public int id;
        public String code;
        public String name;
        public int carTypeId;
        public String carTypeName;
    }
}
