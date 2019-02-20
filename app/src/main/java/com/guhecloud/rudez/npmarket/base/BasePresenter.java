package com.guhecloud.rudez.npmarket.base;

/**
 * Created by Chanin on 2017/6/14.
 */
public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();


}
