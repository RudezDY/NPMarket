package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.google.gson.Gson;
import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.commonmodel.http.HttpHelper;
import com.guhecloud.rudez.npmarket.http.HttpCallBack;
import com.guhecloud.rudez.npmarket.http.HttpUtil;
import com.guhecloud.rudez.npmarket.http.JSONParser;
import com.guhecloud.rudez.npmarket.mvp.contract.SearchContract;
import com.guhecloud.rudez.npmarket.mvp.model.CarListObj;
import com.guhecloud.rudez.npmarket.mvp.model.GoodsListObj;
import com.guhecloud.rudez.npmarket.mvp.model.MerchantListObj;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class SearchPresenter extends RxPresenter<SearchContract.View> implements SearchContract.Presenter {

    public final int TYPE_CAR = 111;
    public final int TYPE_GOODS = 222;
    public final int TYPE_MERCHANT = 333;
    public final int TYPE_BOOK = 444;
    public final int TYPE_NOTICE = 555;

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
            case TYPE_CAR://搜车辆
                HttpUtil.searchCar(curPage, pageSize, keyWord, new HttpCallBack() {
                    @Override
                    public void onSuccess(String result) {
                        CarListObj carListObj = new Gson().fromJson(result,CarListObj.class);
                        mView.onCarSuccess(carListObj);
                    }

                    @Override
                    public void onFailure(String error) {

                    }
                });

                break;
            case TYPE_GOODS://搜商品
                HttpUtil.searchGoods(curPage, pageSize, keyWord, new HttpCallBack() {
                    @Override
                    public void onSuccess(String result) {
                        GoodsListObj goodsListObj = new Gson().fromJson(result,GoodsListObj.class);
                        mView.onGoodsSuccess(goodsListObj);
                    }

                    @Override
                    public void onFailure(String error) {

                    }
                });

                break;
            case TYPE_MERCHANT://搜客户
                HttpUtil.searchMerchant(curPage, pageSize, keyWord, new HttpCallBack() {
                    @Override
                    public void onSuccess(String result) {
                        MerchantListObj merchantListObj = new Gson().fromJson(result,MerchantListObj.class);
                        mView.onMerchantSuccess(merchantListObj);
                    }

                    @Override
                    public void onFailure(String error) {

                    }
                });
                break;
            case TYPE_BOOK://搜联系人

                break;
            case TYPE_NOTICE://搜通知公告

                break;
        }
    }

    /**
     * 获取车辆详情
     * @param id
     */
    public void getCarDetails(int id){
        HttpUtil.getCarDetails(id, new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                mView.onCarDetailSuccess(result);

            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    /**
     * 获取商品详情
     * @param offerId
     */
    public void getGoodsDetails(String offerId){
        HttpUtil.getGoodsDetails(offerId, new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                mView.onGoodsDetailSuccess(result);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    /**
     * 获取商户详情
     * @param id
     */
    public void getMerchantDetails(int id){
        HttpUtil.getMerchantDetails(id, new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                mView.onMerchantDetailSuccess(result);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }


}
