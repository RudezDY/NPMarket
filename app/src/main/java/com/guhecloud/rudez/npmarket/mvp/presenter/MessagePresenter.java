package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.mvp.contract.MessageContract;

import javax.inject.Inject;


public class MessagePresenter extends RxPresenter<MessageContract.View> implements MessageContract.Presenter {


    @Inject
    public MessagePresenter() {
    }


}
