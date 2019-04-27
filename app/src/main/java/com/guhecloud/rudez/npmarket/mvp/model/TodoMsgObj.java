package com.guhecloud.rudez.npmarket.mvp.model;

import java.util.List;

/**
 * Created by homework on 2019/4/26.
 */

public class TodoMsgObj {

    /**
     * records : [{"id":18748,"todoType":"5","todoTypeName":"满意度调查","todoContent":"测试调查问卷5","applyUserName":"莫伊","applyUserDep":"总办","applyUserPhone":"18227606535","applyDate":"2019-04-24 22:02:04","groupDate":null,"state":"0","businessId":3251},{"id":18738,"todoType":"5","todoTypeName":"满意度调查","todoContent":"测试调查问卷3","applyUserName":"莫伊","applyUserDep":"总办","applyUserPhone":"18227606535","applyDate":"2019-04-24 21:46:30","groupDate":null,"state":"0","businessId":1608},{"id":18737,"todoType":"5","todoTypeName":"满意度调查","todoContent":"测试调查问卷6","applyUserName":"莫伊","applyUserDep":"总办","applyUserPhone":"18227606535","applyDate":"2019-04-24 21:46:30","groupDate":null,"state":"0","businessId":3520},{"id":6441,"todoType":"3","todoTypeName":"商品采价","todoContent":"采价任务测试-采价任务测试111","applyUserName":"莫伊","applyUserDep":"总办","applyUserPhone":"18227606535","applyDate":"2019-04-23 10:20:00","groupDate":null,"state":"0","businessId":3466}]
     * total : 4
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
    public List<TodoMsg> records;

    public static class TodoMsg {
        /**
         * id : 18748
         * todoType : 5
         * todoTypeName : 满意度调查
         * todoContent : 测试调查问卷5
         * applyUserName : 莫伊
         * applyUserDep : 总办
         * applyUserPhone : 18227606535
         * applyDate : 2019-04-24 22:02:04
         * groupDate : null
         * state : 0
         * businessId : 3251
         */

        public int id;
        public String todoType;
        public String todoTypeName;
        public String todoContent;
        public String applyUserName;
        public String applyUserDep;
        public String applyUserPhone;
        public String applyDate;
        public String groupDate;
        public String state;
        public int businessId;
    }
}
