package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.google.gson.Gson;
import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.commonmodel.http.HttpHelper;
import com.guhecloud.rudez.npmarket.commonmodel.http.response.ResultMessage;
import com.guhecloud.rudez.npmarket.mvp.contract.MineContract;
import com.guhecloud.rudez.npmarket.util.LogUtil;
import com.guhecloud.rudez.npmarket.util.RxUtil;

import javax.inject.Inject;

import io.reactivex.subscribers.ResourceSubscriber;


public class MinePresenter extends RxPresenter<MineContract.View> implements MineContract.Presenter {


    HttpHelper httpHelper;

    @Inject
    public MinePresenter(HttpHelper httpHelper){
        this.httpHelper=httpHelper;
    }


    @Override
    public void login(String username, String psd) {
        addSubscribe(httpHelper.noCacheHttpApis.register(username,psd)
        .compose(RxUtil.handlerResultMessage())
                .compose(RxUtil.<ResultMessage>rxSchedulerHelper())
                .subscribeWith(new ResourceSubscriber<ResultMessage>() {
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
                        LogUtil.i("完成");
                    }
                })
        );
    }
}
