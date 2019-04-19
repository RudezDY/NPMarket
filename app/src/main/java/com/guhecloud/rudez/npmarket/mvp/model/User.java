package com.guhecloud.rudez.npmarket.mvp.model;

/**
 * Created by homework on 2019/4/3.
 */

    public class User {
        static User user;
        public static User getInstance(){
            if (user==null)
                user=new User();
            return user;
        }
        public void setUser(User user){
            token=user.token;
            userName=user.userName;
            alias=user.alias;
        }
        /**
         * token : 1MsREf4oMTybdzMFZPJ9E4cWMHeUwiT9Vzub/djavZwKjrqcTfAc3m5KACX/s4AALhq6x7rOU+x5RB3In2cSRkM33SXAP3ENdam3VVvAdb8EkK+9OgO8dVbS7C5eLlkiYGrwX+sPLjTrKM92t73OumVIGhK8gyLZygXq2ZdNj0qxniSAhASrcUE51c4vUB/8
         * userName : faircheng
         * alias : 莫伊
         */
        public String token;
        public String userName;
        public String alias;
    }
