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

    public String token="1MsREf4oMTznc7JJwdN5PC3cDSULGdd6s6rJru2++qGvhhXa/5Too9viCFQiyeV9vgGIdR6UYFO8DlQqT/N1fRzR20bCx9FcEMNzsrRsboGJWcBNYJPWR4AFaJ7RGcgS8U2cRhUQS1WI9nsPT/XcYjNbcdQQsy+NMIdScldijp8=";
}
