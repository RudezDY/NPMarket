package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.google.gson.Gson;
import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.commonmodel.http.HttpHelper;
import com.guhecloud.rudez.npmarket.http.HttpCallBack;
import com.guhecloud.rudez.npmarket.http.HttpUtil;
import com.guhecloud.rudez.npmarket.mvp.contract.MsgFragmentContract;
import com.guhecloud.rudez.npmarket.mvp.model.NoticeMsgObj;
import com.guhecloud.rudez.npmarket.mvp.model.TodoMsgObj;
import com.guhecloud.rudez.npmarket.mvp.model.WarningMsgObj;

import javax.inject.Inject;


public class MsgFragmentPresenter extends RxPresenter<MsgFragmentContract.View> implements MsgFragmentContract.Presenter {

    HttpHelper httpHelper;
    @Inject
    public MsgFragmentPresenter(HttpHelper httpHelper) {
        this.httpHelper=httpHelper;
    }


    public void getWaningMsg(int curPage,int pageSize){
        HttpUtil.getMsgWARNING(curPage, pageSize, new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                WarningMsgObj warningMsgObj =new Gson().fromJson(result,WarningMsgObj.class);
                mView.onWarningGet(warningMsgObj);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    public void getTodoMsg(int curPage,int pageSize){
        HttpUtil.getMsgTODO(curPage, pageSize, new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                TodoMsgObj todoMsgObj = new Gson().fromJson(result,TodoMsgObj.class);
                mView.onTodoGet(todoMsgObj);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    public void getNoticeMsg(int curPage,int pageSize){
        HttpUtil.getMsgNotice(curPage, pageSize, new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                NoticeMsgObj noticeMsgObj = new Gson().fromJson(result,NoticeMsgObj.class);

                mView.onNoticeGet(noticeMsgObj);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }


}
