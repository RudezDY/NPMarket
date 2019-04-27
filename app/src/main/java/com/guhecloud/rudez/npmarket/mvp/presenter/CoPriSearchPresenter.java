package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.google.gson.Gson;
import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.commonmodel.http.HttpHelper;
import com.guhecloud.rudez.npmarket.http.HttpCallBack;
import com.guhecloud.rudez.npmarket.http.HttpUtil;
import com.guhecloud.rudez.npmarket.mvp.contract.CoPriSearchContract;
import com.guhecloud.rudez.npmarket.mvp.model.CoPriSearchObj;

import javax.inject.Inject;


public class CoPriSearchPresenter extends RxPresenter<CoPriSearchContract.View> implements CoPriSearchContract.Presenter {


    HttpHelper httpHelper;

    @Inject
    public CoPriSearchPresenter(HttpHelper httpHelper){
        this.httpHelper=httpHelper;
    }


    public void getPriceGoods(int cur,int pageSize,String searchKey){
        HttpUtil.getPriceGoods(cur, pageSize, searchKey, new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                CoPriSearchObj searchObj=new Gson().fromJson(result,CoPriSearchObj.class);
                mView.onDataGet(searchObj);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    public void getMerchantByGoods(int cur,int pageSize,String offerId,String searchKey){
        HttpUtil.getMerchantByGoods(cur, pageSize, offerId, searchKey, new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                CoPriSearchObj searchObj=new Gson().fromJson(result,CoPriSearchObj.class);
                mView.onDataGet(searchObj);
            }

            @Override
            public void onFailure(String error) {

            }
        });

    }

    public void getGoodsByTask(int taskId,int todoId){
        HttpUtil.getGoodsByTask(taskId, todoId, new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                CoPriSearchObj searchObj=new Gson().fromJson(result,CoPriSearchObj.class);
                mView.onDataGet(searchObj);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

}
