package com.guhecloud.rudez.npmarket.ui.search;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.adapter.CarInOutAdapter;
import com.guhecloud.rudez.npmarket.base.BaseActivity;
import com.guhecloud.rudez.npmarket.mvp.model.CarDetail;
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
    @BindView(R.id.tv_carNum)
    TextView tv_carNum;
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

    CarInOutAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_car_details;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        setToolBar(toolbar,"车辆详情",true);
        setScroll();

        initRv();
        String carJson=getIntent().getStringExtra("carJson");
        CarDetail carDetail=new Gson().fromJson(carJson,CarDetail.class);
        if (carDetail!=null)
            setData(carDetail);


    }

    private void setData(CarDetail carDetail) {
        tv_carNum.setText(carDetail.carNo);
        tv_carType.setText(carDetail.carTypeName);
        tv_carOwnerName.setText(carDetail.carOwnerName);
        tv_tel.setText(carDetail.contactNumber);
        tv_merchantName.setText(carDetail.shopStallsName);
        tv_booth.setText(carDetail.shopStallsName);

        adapter.setNewData(carDetail.carEnterOutList);
    }

    private void initRv() {
        LinearLayoutManager layoutManager =new LinearLayoutManager(thisActivity){
            @Override
            public boolean canScrollVertically() {
                //禁止垂直滑动
                return false;
            }
        };
        rv_carInOut.setLayoutManager(layoutManager);
        adapter=new CarInOutAdapter(R.layout.item_car_inout);
        rv_carInOut.setAdapter(adapter);
    }

    private void setScroll() {
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
