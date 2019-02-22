package com.guhecloud.rudez.npmarket.ui.message;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.contract.MessageContract;
import com.guhecloud.rudez.npmarket.mvp.presenter.MessagePresenter;
import com.guhecloud.rudez.npmarket.ui.main.HomeBaseActivity;

public class MessageActivity extends HomeBaseActivity<MessagePresenter> implements MessageContract.View {


    @Override
    protected void injectObject() {
    getActivityComponent().Inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {

    }

    @Override
    public void showError(String msg) {

    }
}
