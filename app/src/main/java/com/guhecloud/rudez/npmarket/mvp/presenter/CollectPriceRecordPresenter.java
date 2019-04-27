package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.commonmodel.http.HttpHelper;
import com.guhecloud.rudez.npmarket.http.HttpCallBack;
import com.guhecloud.rudez.npmarket.http.HttpUtil;
import com.guhecloud.rudez.npmarket.mvp.contract.CollectPriceRecordContract;
import com.guhecloud.rudez.npmarket.mvp.model.PriceRecordObj;
import com.guhecloud.rudez.npmarket.mvp.model.WeekObj;

import java.util.List;

import javax.inject.Inject;


public class CollectPriceRecordPresenter extends RxPresenter<CollectPriceRecordContract.View> implements CollectPriceRecordContract.Presenter {


    HttpHelper httpHelper;

    @Inject
    public CollectPriceRecordPresenter(HttpHelper httpHelper){
        this.httpHelper=httpHelper;
    }

    //获取采价记录
    public void getRecord(int curPage,int pageSie,String applyDateFrom,
                          String applyDateTo,String offerType,String search){
        HttpUtil.getPriceRecord(curPage, pageSie, applyDateFrom, applyDateTo, offerType, search, new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                PriceRecordObj priceRecordObj = new Gson().fromJson(result,PriceRecordObj.class);
                mView.onRecordGet(priceRecordObj);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }


    public void getWeekList(){
        HttpUtil.getWeekList(new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                List<WeekObj> weekList = new Gson().fromJson(result,new TypeToken<List<WeekObj>>(){}.getType());
                mView.onWeekListGet(weekList);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

}
