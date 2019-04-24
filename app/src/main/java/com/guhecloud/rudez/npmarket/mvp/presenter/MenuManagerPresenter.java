package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.google.gson.Gson;
import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.http.HttpCallBack;
import com.guhecloud.rudez.npmarket.http.HttpUtil;
import com.guhecloud.rudez.npmarket.mvp.contract.MenuManagerContract;
import com.guhecloud.rudez.npmarket.mvp.model.AppletObj;
import com.guhecloud.rudez.npmarket.util.ToastUtil;

import java.util.List;

import javax.inject.Inject;


public class MenuManagerPresenter extends RxPresenter<MenuManagerContract.View> implements MenuManagerContract.Presenter {


    @Inject
    public MenuManagerPresenter() {
    }

    public void getAppletInfo(){
        HttpUtil.getAppletInfo(new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                AppletObj  appletObj = new Gson().fromJson(result,AppletObj.class);
                mView.onAppletGet(appletObj);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    public void saveAppletInfo(List<Integer> appIds){
        HttpUtil.saveAppletInfo(appIds, new HttpCallBack() {
            @Override
            public void onSuccess(String result) {

            }

            @Override
            public void onFailure(String error) {
                ToastUtil.show(error);
            }
        });
    }


}
