package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.commonmodel.http.HttpHelper;
import com.guhecloud.rudez.npmarket.mvp.contract.SearchContract;

import javax.inject.Inject;


public class SearchPresenter extends RxPresenter<SearchContract.View> implements SearchContract.Presenter {


    HttpHelper httpHelper;

    @Inject
    public SearchPresenter(HttpHelper httpHelper){
        this.httpHelper=httpHelper;
    }


}
