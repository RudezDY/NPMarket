package com.guhecloud.rudez.npmarket.ui.search;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.adapter.BoothAdapter;
import com.guhecloud.rudez.npmarket.adapter.StockAdapter;
import com.guhecloud.rudez.npmarket.base.BaseActivity;
import com.guhecloud.rudez.npmarket.mvp.model.MerchantDetail;
import com.guhecloud.rudez.npmarket.util.SystemUtil;

import butterknife.BindView;

public class MerchantDetailsActivity extends BaseActivity {

    @BindView(R.id.rv_booth)
    RecyclerView rv_booth;
    @BindView(R.id.rv_stock)
    RecyclerView rv_stock;
    @BindView(R.id.view_scroll)
    NestedScrollView view_scroll;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_shopName)
    TextView tv_shopName;
    @BindView(R.id.tv_merchantType)
    TextView tv_merchantType;
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.tv_goodsName)
    TextView tv_goodsName;

    BoothAdapter boothAdapter;
    StockAdapter stockAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_merchant_details;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        setToolBar(toolbar,"客户详情",true);
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

        initRv();

        String merchantJson = getIntent().getStringExtra("merchantJson");
        MerchantDetail merchantDetail = new Gson().fromJson(merchantJson,MerchantDetail.class);

        tv_shopName.setText(merchantDetail.custName);
        tv_merchantType.setText(merchantDetail.custTypeId);
        tv_name.setText(merchantDetail.custName);
        tv_goodsName.setText("主营商品："+merchantDetail.mainBusinessOffer);
        boothAdapter.setNewData(merchantDetail.shopStallsDTOList);
        stockAdapter.setNewData(merchantDetail.custEnterGoodsDTOList);


    }

    private void initRv() {
        LinearLayoutManager layoutManager1 =new LinearLayoutManager(thisActivity){
            @Override
            public boolean canScrollVertically() {
                //禁止垂直滑动
                return false;
            }
        };

        LinearLayoutManager layoutManager2 =new LinearLayoutManager(thisActivity){
            @Override
            public boolean canScrollVertically() {
                //禁止垂直滑动
                return false;
            }
        };
        rv_booth.setLayoutManager(layoutManager1);
        rv_stock.setLayoutManager(layoutManager2);
        boothAdapter=new BoothAdapter(R.layout.item_booth);
        stockAdapter=new StockAdapter(R.layout.item_stock);
        rv_booth.setAdapter(boothAdapter);
        rv_stock.setAdapter(stockAdapter);
    }
}
