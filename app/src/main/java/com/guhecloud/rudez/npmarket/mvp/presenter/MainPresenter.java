package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.mvp.contract.MainContract;
import com.guhecloud.rudez.npmarket.mvp.contract.ScanContract;

import javax.inject.Inject;


public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {


    @Inject
    public MainPresenter() {
    }


}
