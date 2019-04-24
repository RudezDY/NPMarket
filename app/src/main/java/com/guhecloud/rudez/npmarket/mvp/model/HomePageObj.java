package com.guhecloud.rudez.npmarket.mvp.model;

import java.util.List;

/**
 * Created by homework on 2019/4/23.
 */

public class HomePageObj {
    public List<BannerObj> bannerList;
    public List<AppletModel> applicationList;
    public List<GTask> todoList;

    class BannerObj{

        /**
         * id : 5701
         * noticeTitle : 111
         * noticeTypeName : 置顶公告
         * noticeContent : <p>2222</p>
         * readingNum : 0
         * createdBy : faircheng
         * createdDate : 2019-04-22 02:05:00
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
