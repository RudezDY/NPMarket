package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.commonmodel.http.HttpHelper;
import com.guhecloud.rudez.npmarket.http.HttpCallBack;
import com.guhecloud.rudez.npmarket.http.HttpUtil;
import com.guhecloud.rudez.npmarket.mvp.contract.CollectPriceContract;
import com.guhecloud.rudez.npmarket.mvp.model.PicObj;

import java.io.File;
import java.util.List;

import javax.inject.Inject;


public class CollectPricePresenter extends RxPresenter<CollectPriceContract.View> implements CollectPriceContract.Presenter {


    HttpHelper httpHelper;

    @Inject
    public CollectPricePresenter(HttpHelper httpHelper){
        this.httpHelper=httpHelper;
    }


    public void commitPrice(int id,String custId,String custName,String offerId,String offerName,
                            String productAreaName,double maxPrice,double midPrice,double minPrice,
                            String unit,List<PicObj> pictures,
                            int taskId,int todoId,String taskName){

        HttpUtil.collectPrice(id, custId, custName, offerId, offerName, productAreaName, maxPrice, midPrice, minPrice
                , unit, pictures, taskId, todoId, taskName, new HttpCallBack() {
                    @Override
                    public void onSuccess(String result) {
                        mView.onCommitSuccess();
                    }

                    @Override
                    public void onFailure(String error) {

                    }
                });

    }


    public void upLoad(List<File> files){
        HttpUtil.upLoadImg(files, new HttpCallBack() {
            @Override
            public void onSuccess(String result) {

            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

}
