package com.guhecloud.rudez.npmarket.ui.mine;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.base.BaseActivity;
import com.guhecloud.rudez.npmarket.util.SystemUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class AboutOurActivity extends BaseActivity {

    @BindView(R.id.view_toolbar)
    Toolbar view_toolbar;
    @BindView(R.id.tv_version)
    TextView tv_version;
    @BindView(R.id.layout_version)
    LinearLayout layout_version;
    @BindView(R.id.layout_intro)
    LinearLayout layout_intro;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_about_our;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        setToolBar(view_toolbar,"关于",true);
        tv_version.setText(SystemUtil.getVersionName());
    }

    @OnClick({R.id.layout_intro,R.id.layout_version})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.layout_version:

                break;
            case R.id.layout_intro:

                break;
        }
    }
}
