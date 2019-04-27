package com.guhecloud.rudez.npmarket.mvp.contract;


import com.guhecloud.rudez.npmarket.base.BasePresenter;
import com.guhecloud.rudez.npmarket.base.BaseView;
import com.guhecloud.rudez.npmarket.mvp.model.MsgCountObj;

public interface MessageContract {

    interface View extends BaseView {
        void onMsgCountGet(MsgCountObj msgCountObj);
    }


    interface Presenter extends BasePresenter<View> {

    }

}
