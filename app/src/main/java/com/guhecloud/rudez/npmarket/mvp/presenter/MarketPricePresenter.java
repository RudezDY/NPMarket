package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.commonmodel.http.HttpHelper;
import com.guhecloud.rudez.npmarket.http.HttpCallBack;
import com.guhecloud.rudez.npmarket.http.HttpUtil;
import com.guhecloud.rudez.npmarket.mvp.contract.MarketPriceContract;
import com.guhecloud.rudez.npmarket.mvp.model.MarketPriceObj;
import com.guhecloud.rudez.npmarket.mvp.model.WeekObj;

import java.util.List;

import javax.inject.Inject;


public class MarketPricePresenter extends RxPresenter<MarketPriceContract.View> implements MarketPriceContract.Presenter {


    HttpHelper httpHelper;

    @Inject
    public MarketPricePresenter(HttpHelper httpHelper){
        this.httpHelper=httpHelper;
    }

    public void getMarketPrice(String startDate,String endDate){
        HttpUtil.getMarketPrice(startDate, endDate, new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                List<MarketPriceObj> list= new Gson().fromJson(result, new TypeToken<List<MarketPriceObj>>() {}.getType());
                mView.onPriceGet(list);
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
                mView.onWekListGet(weekList);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }


}
