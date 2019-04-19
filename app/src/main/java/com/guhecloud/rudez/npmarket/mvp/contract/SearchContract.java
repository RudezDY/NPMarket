package com.guhecloud.rudez.npmarket.mvp.contract;


import com.guhecloud.rudez.npmarket.base.BasePresenter;
import com.guhecloud.rudez.npmarket.base.BaseView;

import java.util.List;

public interface SearchContract {

    interface View extends BaseView {
        void onHistorySuccess(List<String> historyList);
    }


    interface Presenter extends BasePresenter<View> {

    }

}
