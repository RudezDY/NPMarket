package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.mvp.contract.MineContract;
import com.guhecloud.rudez.npmarket.mvp.contract.ScanContract;

import javax.inject.Inject;


public class MinePresenter extends RxPresenter<MineContract.View> implements MineContract.Presenter {


    @Inject
    public MinePresenter() {
    }


}
