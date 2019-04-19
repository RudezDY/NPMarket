package com.guhecloud.rudez.npmarket.ui.search;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.base.BaseActivity;
import com.guhecloud.rudez.npmarket.util.SystemUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class CarDetailsActivity extends BaseActivity {

    @BindView(R.id.rv_carInOut)
    RecyclerView rv_carInOut;
    @BindView(R.id.view_scroll)
    NestedScrollView view_scroll;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_cardType)
    TextView tv_cardType;
    @BindView(R.id.tv_carType)
    TextView tv_carType;
    @BindView(R.id.tv_carOwnerName)
    TextView tv_carOwnerName;
    @BindView(R.id.tv_tel)
    TextView tv_tel;
    @BindView(R.id.tv_merchantName)
    TextView tv_merchantName;
    @BindView(R.id.tv_booth)
    TextView tv_booth;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_car_details;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        setToolBar(toolbar,"商品详情",true);
        view_scroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY>= SystemUtil.dp2px(145)){
                    toolbar.setBackgroundColor(getResources().getColor(R.color.orange));
                }else {
                    toolbar.setBackgroundColor(getResources().getColor(R.color.trans));
                }
            }
        });

        LinearLayoutManager layoutManager =new LinearLayoutManager(thisActivity){
            @Override
            public boolean canScrollVertically() {
                //禁止垂直滑动
                return false;
            }
        };
        rv_carInOut.setLayoutManager(layoutManager);
    }

    @OnClick({R.id.tv_tel})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.tv_tel:
                SystemUtil.callPhone(activityWeakReference.get(),tv_tel.getText().toString());
                break;
        }
    }
}
