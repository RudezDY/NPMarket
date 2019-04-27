package com.guhecloud.rudez.npmarket.mvp.model;

import java.util.List;

/**
 * Created by homework on 2019/4/26.
 */

public class NoticeMsgObj {

    /**
     * records : [{"id":3751,"noticeTitle":"测试标题222","noticeTypeName":"置顶公告","noticeContent":"测试内容111","readingNum":0,"createdBy":"faircheng","createdDate":"2019-04-13 14:34:01","readStatus":"0","noticeImgUrl":null},{"id":5701,"noticeTitle":"111","noticeTypeName":"置顶公告","noticeContent":"<p>2222<\/p>","readingNum":0,"createdBy":"faircheng","createdDate":"2019-04-22 02:05:00","readStatus":"0","noticeImgUrl":null},{"id":571,"noticeTitle":"测试标题2","noticeTypeName":"置顶公告","noticeContent":"测试内容2","readingNum":2,"createdBy":"admin","createdDate":"2019-03-25 07:03:38","readStatus":"1","noticeImgUrl":null}]
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
    public List<NoticeMsg> records;

    public static class NoticeMsg {
        /**
         * id : 3751
         * noticeTitle : 测试标题222
         * noticeTypeName : 置顶公告
         * noticeContent : 测试内容111
         * readingNum : 0
         * createdBy : faircheng
         * createdDate : 2019-04-13 14:34:01
         * readStatus : 0
         * noticeImgUrl : null
         */

        public int id;
        public String noticeTitle;
        public String noticeTypeName;
        public String noticeContent;
        public int readingNum;
        public String createdBy;
        public String createdDate;
        public String readStatus;
        public Object noticeImgUrl;
    }
}
