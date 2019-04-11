package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.commonmodel.http.HttpHelper;
import com.guhecloud.rudez.npmarket.mvp.contract.MineContract;

import javax.inject.Inject;


public class MinePresenter extends RxPresenter<MineContract.View> implements MineContract.Presenter {


    HttpHelper httpHelper;

    @Inject
    public MinePresenter(HttpHelper httpHelper){
        this.httpHelper=httpHelper;
    }


}
