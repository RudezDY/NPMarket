package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.mvp.contract.MenuManagerContract;
import com.guhecloud.rudez.npmarket.mvp.contract.ScanContract;

import javax.inject.Inject;


public class MenuManagerPresenter extends RxPresenter<MenuManagerContract.View> implements MenuManagerContract.Presenter {


    @Inject
    public MenuManagerPresenter() {
    }


}
