package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.mvp.contract.MsgFragmentContract;

import javax.inject.Inject;


public class MsgFragmentPresenter extends RxPresenter<MsgFragmentContract.View> implements MsgFragmentContract.Presenter {


    @Inject
    public MsgFragmentPresenter() {
    }


}
