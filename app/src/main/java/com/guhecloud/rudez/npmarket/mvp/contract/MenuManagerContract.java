package com.guhecloud.rudez.npmarket.mvp.contract;


import com.guhecloud.rudez.npmarket.base.BasePresenter;
import com.guhecloud.rudez.npmarket.base.BaseView;
import com.guhecloud.rudez.npmarket.mvp.model.AppletObj;

public interface MenuManagerContract {

    interface View extends BaseView {

        void onAppletGet(AppletObj appletObj);

    }


    interface Presenter extends BasePresenter<View> {

    }

}
