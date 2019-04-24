package com.guhecloud.rudez.npmarket.mvp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页小应用实体类
 * Created by homework on 2019/2/20.
 */

public class AppletModel {
    public int id;
    public String menuName;
    public String menuCode;
    public String priority;
    public String url;
    public String menuLogo;

    private boolean isCollect;
    public AppletModel(String appName) {
        this.menuName = appName;
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

    public boolean isCollect() {
        return isCollect;
    }

    public void setCollect(boolean collect) {
        isCollect = collect;
    }
}
