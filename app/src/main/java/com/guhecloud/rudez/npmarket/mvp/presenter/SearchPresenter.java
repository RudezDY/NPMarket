package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.commonmodel.http.HttpHelper;
import com.guhecloud.rudez.npmarket.http.HttpCallBack;
import com.guhecloud.rudez.npmarket.http.HttpUtil;
import com.guhecloud.rudez.npmarket.http.JSONParser;
import com.guhecloud.rudez.npmarket.mvp.contract.SearchContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class SearchPresenter extends RxPresenter<SearchContract.View> implements SearchContract.Presenter {


    HttpHelper httpHelper;

    @Inject
    public SearchPresenter(HttpHelper httpHelper){
        this.httpHelper=httpHelper;
    }

    //获取搜索历史
    public void getSearchHistory(){
        HttpUtil.getSearchHistory(new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                List<String> historyList = JSONParser.JSON2Array(result,String.class);
                mView.onHistorySuccess(historyList);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    //清空搜索历史
    public void clearHistory(){
        HttpUtil.clearSearchHistory(new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                mView.onHistorySuccess(new ArrayList<String>());
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    public void search(int type,int curPage,int pageSize,String keyWord){
        switch (type){
            case 111://搜车辆
                HttpUtil.searchCar(curPage, pageSize, keyWord, new HttpCallBack() {
                    @Override
                    public void onSuccess(String result) {

                    }

                    @Override
                    public void onFailure(String error) {

                    }
                });

                break;
            case 222://搜商品

                break;
            case 333://搜客户
                HttpUtil.searchMerchant(curPage, pageSize, keyWord, new HttpCallBack() {
                    @Override
                    public void onSuccess(String result) {

                    }

                    @Override
                    public void onFailure(String error) {

                    }
                });
                break;
            case 444://搜联系人

                break;
            case 555://搜通知公告

                break;
        }
    }


}
