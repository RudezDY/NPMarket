package com.guhecloud.rudez.npmarket.mvp.contract;


import com.guhecloud.rudez.npmarket.base.BasePresenter;
import com.guhecloud.rudez.npmarket.base.BaseView;
import com.guhecloud.rudez.npmarket.mvp.model.PriceRecordObj;

public interface CollectPriceRecordContract {

    interface View extends BaseView {
        void onRecordGet(PriceRecordObj recordObj);
    }


    interface Presenter extends BasePresenter<View> {

    }

}
