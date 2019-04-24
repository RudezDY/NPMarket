package com.guhecloud.rudez.npmarket.mvp.contract;


import com.guhecloud.rudez.npmarket.base.BasePresenter;
import com.guhecloud.rudez.npmarket.base.BaseView;
import com.guhecloud.rudez.npmarket.mvp.model.CarListObj;
import com.guhecloud.rudez.npmarket.mvp.model.GoodsListObj;
import com.guhecloud.rudez.npmarket.mvp.model.MerchantListObj;

import java.util.List;

public interface SearchContract {

    interface View extends BaseView {
        void onHistorySuccess(List<String> historyList);

        void onCarSuccess(CarListObj carListObj);
        void onGoodsSuccess(GoodsListObj goodsListObj);
        void onMerchantSuccess(MerchantListObj merchantListObj);

        void onCarDetailSuccess(String carDetailJson);
        void onGoodsDetailSuccess(String goodsDetailJson);
        void onMerchantDetailSuccess(String merchantDetailJson);
    }


    interface Presenter extends BasePresenter<View> {

    }

}
