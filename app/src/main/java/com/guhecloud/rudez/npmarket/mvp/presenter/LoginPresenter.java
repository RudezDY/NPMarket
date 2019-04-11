package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.google.gson.Gson;
import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.commonmodel.http.HttpHelper;
import com.guhecloud.rudez.npmarket.commonmodel.http.response.ResultMessage;
import com.guhecloud.rudez.npmarket.mvp.contract.LoginContract;
import com.guhecloud.rudez.npmarket.mvp.model.User;
import com.guhecloud.rudez.npmarket.util.LogUtil;
import com.guhecloud.rudez.npmarket.util.RxUtil;

import javax.inject.Inject;

import io.reactivex.subscribers.ResourceSubscriber;


public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter {


    HttpHelper httpHelper;
    @Inject
    public LoginPresenter(HttpHelper httpHelper) {
        this.httpHelper=httpHelper;
    }

    public void login(String username, String psd){
        addSubscribe(httpHelper.noCacheHttpApis.login(username,psd)
                .compose(RxUtil.handlerResultMessage())
                .compose(RxUtil.<ResultMessage>rxSchedulerHelper())
                .subscribeWith(new ResourceSubscriber<ResultMessage>(){
                    @Override
                    public void onNext(ResultMessage resultMessage) {
                        LogUtil.i(new Gson().toJson(resultMessage));
                    }

                    @Override
                    public void onError(Throwable t) {
                        LogUtil.i(t.toString());
                    }

                    @Override
                    public void onComplete() {
                    LogUtil.i("完成请求");
                    }
                })
        );
    }

    public void tokenLogin(){
        addSubscribe(httpHelper.noCacheHttpApis.tokenLogin(User.getInstance().token)
                .compose(RxUtil.handlerResultMessage())
                .compose(RxUtil.<ResultMessage>rxSchedulerHelper())
                .subscribeWith(new ResourceSubscriber<ResultMessage>(){
                    @Override
                    public void onNext(ResultMessage resultMessage) {
                        LogUtil.i(new Gson().toJson(resultMessage));
                    }

                    @Override
                    public void onError(Throwable t) {
                        LogUtil.i(t.toString());
                    }

                    @Override
                    public void onComplete() {
                    LogUtil.i("完成请求");
                    }
                })
        );
    }


}
