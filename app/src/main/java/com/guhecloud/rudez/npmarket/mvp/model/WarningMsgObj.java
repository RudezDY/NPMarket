package com.guhecloud.rudez.npmarket.mvp.model;

import java.util.List;

/**
 * Created by homework on 2019/4/26.
 */

public class WarningMsgObj {

    /**
     * records : [{"title":"【租约到期提醒】","content":"档位01将于4天后到期，请及时处理。","createdDate":"2019-04-26 00:01:00"},{"title":"【租约到期提醒】","content":"档位02将于4天后到期，请及时处理。","createdDate":"2019-04-26 00:01:00"},{"title":"【租约到期提醒】","content":"档位01将于6天后到期，请及时处理。","createdDate":"2019-04-24 23:05:40"},{"title":"【租约到期提醒】","content":"档位02将于6天后到期，请及时处理。","createdDate":"2019-04-24 23:05:23"}]
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
    public List<WarningMsg> records;

    public static class WarningMsg {
        /**
         * title : 【租约到期提醒】
         * content : 档位01将于4天后到期，请及时处理。
         * createdDate : 2019-04-26 00:01:00
         */

        public String title;
        public String content;
        public String createdDate;
    }
}
