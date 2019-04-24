package com.guhecloud.rudez.npmarket.mvp.contract;


import com.guhecloud.rudez.npmarket.base.BasePresenter;
import com.guhecloud.rudez.npmarket.base.BaseView;
import com.guhecloud.rudez.npmarket.mvp.model.HomePageObj;

public interface MainContract {

    interface View extends BaseView {

        void onHomePageGet(HomePageObj homePageObj);
    }


    interface Presenter extends BasePresenter<View> {

    }

}
