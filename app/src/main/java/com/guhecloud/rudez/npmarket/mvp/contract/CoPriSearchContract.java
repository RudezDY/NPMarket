package com.guhecloud.rudez.npmarket.mvp.contract;


import com.guhecloud.rudez.npmarket.base.BasePresenter;
import com.guhecloud.rudez.npmarket.base.BaseView;
import com.guhecloud.rudez.npmarket.mvp.model.CoPriSearchObj;

public interface CoPriSearchContract {

    interface View extends BaseView {

        void onDataGet(CoPriSearchObj searchObj);
    }


    interface Presenter extends BasePresenter<View> {

    }

}
