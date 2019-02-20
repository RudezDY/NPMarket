package com.guhecloud.rudez.npmarket.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;
import android.text.TextUtils;


import com.guhecloud.rudez.npmarket.app.App;
import com.guhecloud.rudez.npmarket.di.component.ActivityComponent;
import com.guhecloud.rudez.npmarket.di.component.DaggerActivityComponent;
import com.guhecloud.rudez.npmarket.di.module.ActivityMode;
import com.guhecloud.rudez.npmarket.util.ActivityUtil;
import com.guhecloud.rudez.npmarket.util.LoadingDialogUtil;
import com.guhecloud.rudez.npmarket.util.ToastUtil;

import javax.inject.Inject;

/**
 * Created by Chanin on 2017/6/14.
 */
public abstract class RxActivity<T extends BasePresenter> extends BaseActivity implements BaseView {


    @Inject
    public T mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        injectObject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onCreate(savedInstanceState);
    }



    public ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityMode(new ActivityMode(this))
                .build();
    }


    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();

    }

    @Override
    public void useNightMode(boolean isNight) {
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        recreate();

    }

    protected abstract void injectObject();//依赖注入


    @Override
    public void requestFaild() {
        LoadingDialogUtil.closeLoadingDialog();
        ToastUtil.show("网络请求失败，请检查网络后重试");
    }
}
