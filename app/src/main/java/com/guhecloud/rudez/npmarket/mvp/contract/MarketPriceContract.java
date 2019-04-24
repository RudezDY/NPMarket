package com.guhecloud.rudez.npmarket.mvp.contract;


import com.guhecloud.rudez.npmarket.base.BasePresenter;
import com.guhecloud.rudez.npmarket.base.BaseView;
import com.guhecloud.rudez.npmarket.mvp.model.MarketPriceObj;
import com.guhecloud.rudez.npmarket.mvp.model.WeekObj;

import java.util.List;

public interface MarketPriceContract {

    interface View extends BaseView {

        void onPriceGet(List<MarketPriceObj> list);

        void onWekListGet(List<WeekObj> weekList);
    }


    interface Presenter extends BasePresenter<View> {

    }

}
