package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.google.gson.Gson;
import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.http.HttpCallBack;
import com.guhecloud.rudez.npmarket.http.HttpUtil;
import com.guhecloud.rudez.npmarket.mvp.contract.MessageContract;
import com.guhecloud.rudez.npmarket.mvp.model.MsgCountObj;

import javax.inject.Inject;


public class MessagePresenter extends RxPresenter<MessageContract.View> implements MessageContract.Presenter {


    @Inject
    public MessagePresenter() {
    }


    public void getMsgCount(){
        HttpUtil.getMsgCount(new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                MsgCountObj msgCountObj = new Gson().fromJson(result,MsgCountObj.class);
                mView.onMsgCountGet(msgCountObj);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }
}
