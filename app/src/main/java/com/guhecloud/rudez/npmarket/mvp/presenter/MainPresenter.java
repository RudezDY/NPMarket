package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.google.gson.Gson;
import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.http.HttpCallBack;
import com.guhecloud.rudez.npmarket.http.HttpUtil;
import com.guhecloud.rudez.npmarket.mvp.contract.MainContract;
import com.guhecloud.rudez.npmarket.mvp.model.HomePageObj;

import javax.inject.Inject;


public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {


    @Inject
    public MainPresenter() {
    }

    public void getHomePage(){
        HttpUtil.getHomePage(new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                HomePageObj obj = new Gson().fromJson(result,HomePageObj.class);
                mView.onHomePageGet(obj);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }


}
