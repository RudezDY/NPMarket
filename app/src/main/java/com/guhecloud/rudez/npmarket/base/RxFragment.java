package com.guhecloud.rudez.npmarket.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.guhecloud.rudez.npmarket.app.App;
import com.guhecloud.rudez.npmarket.di.component.DaggerFragmentComponent;
import com.guhecloud.rudez.npmarket.di.component.FragmentComponent;
import com.guhecloud.rudez.npmarket.di.module.FragmentModule;
import com.guhecloud.rudez.npmarket.util.LoadingDialogUtil;
import com.guhecloud.rudez.npmarket.util.ToastUtil;

import javax.inject.Inject;

/**
 * Created by Chanin on 2017/6/14.
 */
public abstract class RxFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

    @Inject
    public T mPresenter;


    public FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        injectObject();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {

    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    protected abstract void injectObject();

    @Override
    public void useNightMode(boolean isNight) {

    }


    @Override
    public void requestFaild() {
        LoadingDialogUtil.closeLoadingDialog();
        ToastUtil.show("网络请求失败");
    }
}
