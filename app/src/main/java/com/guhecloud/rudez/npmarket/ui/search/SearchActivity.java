package com.guhecloud.rudez.npmarket.ui.search;

import android.os.Bundle;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.base.RxActivity;
import com.guhecloud.rudez.npmarket.mvp.contract.SearchContract;
import com.guhecloud.rudez.npmarket.mvp.presenter.SearchPresenter;

public class SearchActivity extends RxActivity<SearchPresenter> implements SearchContract.View {

    @Override
    protected void injectObject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {

    }

    @Override
    public void showError(String msg) {

    }
}
