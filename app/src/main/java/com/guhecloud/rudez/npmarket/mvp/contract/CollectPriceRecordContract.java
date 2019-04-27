package com.guhecloud.rudez.npmarket.mvp.contract;


import com.guhecloud.rudez.npmarket.base.BasePresenter;
import com.guhecloud.rudez.npmarket.base.BaseView;
import com.guhecloud.rudez.npmarket.mvp.model.PriceRecordObj;
import com.guhecloud.rudez.npmarket.mvp.model.WeekObj;

import java.util.List;

public interface CollectPriceRecordContract {

    interface View extends BaseView {
        void onRecordGet(PriceRecordObj recordObj);

        void onWeekListGet(List<WeekObj> weekList);
    }


    interface Presenter extends BasePresenter<View> {

    }

}
