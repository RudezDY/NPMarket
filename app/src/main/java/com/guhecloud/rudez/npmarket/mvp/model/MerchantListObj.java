package com.guhecloud.rudez.npmarket.mvp.model;

import java.util.List;

/**
 * Created by homework on 2019/4/22.
 */

public class MerchantListObj {

    /**
     * records : [{"id":2,"code":"02","name":"客户02","custTypeId":"01","shopStallsName":null},{"id":1,"code":"01","name":"客户01","custTypeId":"01","shopStallsName":"档位01,档位02"}]
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
    public List<MerchantObj> records;

    public static class MerchantObj {
        /**
         * id : 2
         * code : 02
         * name : 客户02
         * custTypeId : 01
         * shopStallsName : null
         */

        public int id;
        public String code;
        public String name;
        public String custTypeId;
        public String shopStallsName;
    }
}
