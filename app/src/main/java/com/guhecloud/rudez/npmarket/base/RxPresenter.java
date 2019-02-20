package com.guhecloud.rudez.npmarket.base;


import com.guhecloud.rudez.npmarket.util.RxBus;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Chanin on 2017/6/16.
 */
public class RxPresenter<T extends BaseView> implements BasePresenter<T>{

    protected  T mView;
    protected CompositeDisposable mCompositeDisposable;


    protected void addSubscribe(Disposable disposable){
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    protected <U> void addRxBusSubscribe(Class<U> eventType, Consumer<U> act){
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(RxBus.getDefault().toDefaultFlowable(eventType,act));
    }

    protected void unSubscribe(){
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        unSubscribe();
        this.mView = null;
    }

}
