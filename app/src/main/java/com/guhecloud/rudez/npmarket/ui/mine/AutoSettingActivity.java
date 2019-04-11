package com.guhecloud.rudez.npmarket.ui.mine;

import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.app.App;
import com.guhecloud.rudez.npmarket.base.BaseActivity;
import com.guhecloud.rudez.npmarket.ui.login.LoginActivity;
import com.guhecloud.rudez.npmarket.util.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class AutoSettingActivity extends BaseActivity {

    @BindView(R.id.view_toolbar)
    Toolbar view_toobar;
    @BindView(R.id.btn_switch)
    SwitchCompat btn_switch;
    @BindView(R.id.tv_cache)
    TextView tv_cache;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_auto_setting;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        setToolBar(view_toobar,"通用设置",true);
        btn_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ToastUtil.show("通知");
                }else {
                    ToastUtil.show("禁用通知");
                }
            }
        });
    }

    @OnClick({R.id.layout_clear,R.id.btn_logout})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.layout_clear:
                ToastUtil.show("clear");
                break;
            case R.id.btn_logout:
                App.getInstance().closeAllAty();
                startAty(LoginActivity.class);
                break;
        }

    }
}
