package com.guhecloud.rudez.npmarket.mvp.contract;


import com.guhecloud.rudez.npmarket.base.BasePresenter;
import com.guhecloud.rudez.npmarket.base.BaseView;
import com.guhecloud.rudez.npmarket.mvp.model.User;

public interface LoginContract {

    interface View extends BaseView {

        void onLoginSuccess(User user);

    }


    interface Presenter extends BasePresenter<View> {

    }

}
