package com.guhecloud.rudez.npmarket.mvp.model;

import java.util.List;

/**
 * Created by homework on 2019/4/24.
 */

public class PriceRecordObj {

    /**
     * records : [{"id":7,"taskId":3466,"taskName":"采价任务测试","todoId":null,"offerId":"01010101","offerName":"白菜","custId":"一加一蔬菜批发部","custName":"一加一蔬菜批发部","maxPrice":1.6,"midPrice":1.7,"minPrice":1.1,"createdBy":"admin","createdDate":"2019-03-29 08:52:20","productAreaName":null,"pictureUrls":null,"pictures":[]},{"id":5,"taskId":3466,"taskName":"采价任务测试","todoId":null,"offerId":"01010101","offerName":"白菜","custId":"一加一蔬菜批发部","custName":"一加一蔬菜批发部","maxPrice":1.6,"midPrice":1.5,"minPrice":1.1,"createdBy":"admin","createdDate":"2019-03-25 08:52:20","productAreaName":null,"pictureUrls":null,"pictures":[]},{"id":1765,"taskId":3466,"taskName":"采价任务测试","todoId":null,"offerId":"01010102","offerName":"萝卜","custId":"test","custName":"一加一蔬菜批发部","maxPrice":3,"midPrice":2,"minPrice":1,"createdBy":"faircheng","createdDate":"2019-04-04 08:21:10","productAreaName":null,"pictureUrls":null,"pictures":[]},{"id":5743,"taskId":null,"taskName":null,"todoId":null,"offerId":"01010101","offerName":"大白花土豆","custId":null,"custName":null,"maxPrice":1.1,"midPrice":1.1,"minPrice":1.1,"createdBy":"faircheng","createdDate":"2019-04-22 02:43:11","productAreaName":"四川","pictureUrls":"1.jpg,2.jpg","pictures":[{"pictureUrl":"1.jpg"},{"pictureUrl":"2.jpg"}]},{"id":6024,"taskId":null,"taskName":null,"todoId":null,"offerId":"01010101","offerName":"大白花土豆","custId":"01","custName":"客户01","maxPrice":0.9,"midPrice":0.7,"minPrice":0.5,"createdBy":"faircheng","createdDate":"2019-04-22 08:16:56","productAreaName":"四川","pictureUrls":"2.jpg","pictures":[{"pictureUrl":"2.jpg"}]},{"id":6023,"taskId":null,"taskName":null,"todoId":null,"offerId":"01010101","offerName":"大白花土豆","custId":"01","custName":"客户01","maxPrice":0.9,"midPrice":0.7,"minPrice":0.5,"createdBy":"faircheng","createdDate":"2019-04-22 08:16:02","productAreaName":"四川","pictureUrls":null,"pictures":[]},{"id":6020,"taskId":null,"taskName":null,"todoId":null,"offerId":"01010101","offerName":"大白花土豆","custId":"01","custName":"客户01","maxPrice":0.9,"midPrice":0.7,"minPrice":0.5,"createdBy":"faircheng","createdDate":"2019-04-22 08:15:50","productAreaName":"四川","pictureUrls":null,"pictures":[]},{"id":6017,"taskId":null,"taskName":null,"todoId":null,"offerId":"01010101","offerName":"大白花土豆","custId":"01","custName":"客户01","maxPrice":0.9,"midPrice":0.7,"minPrice":0.5,"createdBy":"faircheng","createdDate":"2019-04-22 08:15:30","productAreaName":"四川","pictureUrls":null,"pictures":[]},{"id":6016,"taskId":null,"taskName":null,"todoId":null,"offerId":"01010101","offerName":"大白花土豆","custId":"01","custName":"客户01","maxPrice":0.9,"midPrice":0.7,"minPrice":0.5,"createdBy":"faircheng","createdDate":"2019-04-22 08:14:10","productAreaName":"四川","pictureUrls":null,"pictures":[]},{"id":6015,"taskId":null,"taskName":null,"todoId":null,"offerId":"01010101","offerName":"大白花土豆","custId":"01","custName":"客户01","maxPrice":0.9,"midPrice":0.7,"minPrice":0.5,"createdBy":"faircheng","createdDate":"2019-04-22 08:13:18","productAreaName":"四川","pictureUrls":null,"pictures":[]}]
     * total : 18
     * size : 10
     * current : 1
     * searchCount : true
     * pages : 2
     */

    public int total;
    public int size;
    public int current;
    public boolean searchCount;
    public int pages;
    public List<Record> records;

    public static class Record {
        /**
         * id : 7
         * taskId : 3466
         * taskName : 采价任务测试
         * todoId : null
         * offerId : 01010101
         * offerName : 白菜
         * custId : 一加一蔬菜批发部
         * custName : 一加一蔬菜批发部
         * maxPrice : 1.6
         * midPrice : 1.7
         * minPrice : 1.1
         * unit : 元/斤
         * createdBy : admin
         * createdDate : 2019-03-29 08:52:20
         * productAreaName : null
         * pictureUrls : null
         * pictures : []
         */

        public int id;
        public int taskId;
        public String taskName;
        public int todoId;
        public String offerId;
        public String offerName;
        public String custId;
        public String custName;
        public double maxPrice;
        public double midPrice;
        public double minPrice;
        public String unit;
        public String createdBy;
        public String createdDate;
        public String productAreaName;
        public String pictureUrls;
//        public List<String> pictures;
        public List<PicUrl> pictures;
    }

    public class PicUrl{
        public String pictureUrl;
    }
}
