package com.guhecloud.rudez.npmarket.ui.contacts;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.base.BaseActivity;

import butterknife.BindView;

public class DepartmentListActivity extends BaseActivity {

    @BindView(R.id.view_toolbar)
    Toolbar view_toolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_department_list;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        setToolBar(view_toolbar,"部门列表",true);
    }
}
