package com.guhecloud.rudez.npmarket.mvp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页小应用实体类
 * Created by homework on 2019/2/20.
 */

public class AppletModel {
    private String appName;
    private String url;
    private String icon;
    private boolean isCollect;

    public AppletModel(String appName) {
        this.appName = appName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isCollect() {
        return isCollect;
    }

    public void setCollect(boolean collect) {
        isCollect = collect;
    }

    public static List<AppletModel> getImitateData(){
        List<AppletModel> data=new ArrayList<>();
        data.add(new AppletModel("我的工资"));
        data.add(new AppletModel("商品采价"));
        data.add(new AppletModel("资源申请"));
        data.add(new AppletModel("留言投诉"));
        data.add(new AppletModel("我的考勤"));
        data.add(new AppletModel("营收调整"));
        data.add(new AppletModel("设备巡检"));
        data.add(new AppletModel("投诉管理"));
        data.add(new AppletModel("设备保修"));
        data.add(new AppletModel("满意度调查"));
        data.add(new AppletModel("客服热线"));
        return data;
    }
}
