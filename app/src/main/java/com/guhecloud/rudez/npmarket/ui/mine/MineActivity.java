package com.guhecloud.rudez.npmarket.ui.mine;

import android.os.Bundle;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.contract.MineContract;
import com.guhecloud.rudez.npmarket.mvp.presenter.MinePresenter;
import com.guhecloud.rudez.npmarket.ui.main.HomeBaseActivity;
import com.guhecloud.rudez.npmarket.util.ToastUtil;

public class MineActivity extends HomeBaseActivity<MinePresenter> implements MineContract.View {


    @Override
    protected void injectObject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        mPresenter.login("bosstwzd","123456");
    }

    @Override
    public void showError(String msg) {
        ToastUtil.show(msg);
    }
}
