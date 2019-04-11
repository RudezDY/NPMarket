package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.commonmodel.http.HttpHelper;
import com.guhecloud.rudez.npmarket.mvp.contract.UserInfoContract;

import javax.inject.Inject;


public class UserInfoPresenter extends RxPresenter<UserInfoContract.View> implements UserInfoContract.Presenter {


    HttpHelper httpHelper;

    @Inject
    public UserInfoPresenter(HttpHelper httpHelper){
        this.httpHelper=httpHelper;
    }


}
