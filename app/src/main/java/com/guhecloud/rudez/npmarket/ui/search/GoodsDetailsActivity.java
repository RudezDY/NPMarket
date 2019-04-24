package com.guhecloud.rudez.npmarket.ui.search;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.base.BaseActivity;
import com.guhecloud.rudez.npmarket.mvp.model.GoodsDetail;

import butterknife.BindView;
import butterknife.OnClick;

public class GoodsDetailsActivity extends BaseActivity {

    @BindView(R.id.img_back)
    ImageView img_back;
    @BindView(R.id.tv_goodsName)
    TextView tv_goodsName;
    @BindView(R.id.tv_nikeName)
    TextView tv_nikeName;
    @BindView(R.id.tv_type)
    TextView tv_type;
    @BindView(R.id.tv_price)
    TextView tv_price;
    @BindView(R.id.tv_merchantName)
    TextView tv_merchantName;
    @BindView(R.id.tv_shopName)
    TextView tv_shopName;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods_details;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {

        String goodsDetailJson = getIntent().getStringExtra("goodsJson");
        GoodsDetail goodsDetail=new Gson().fromJson(goodsDetailJson,GoodsDetail.class);
        tv_goodsName.setText(goodsDetail.offerName);
        tv_nikeName.setText(goodsDetail.offerAlias);
        tv_type.setText(goodsDetail.offerType);
        tv_price.setText(goodsDetail.feeH+goodsDetail.unit);
        tv_merchantName.setText(goodsDetail.custName);
        tv_shopName.setText(goodsDetail.shopStallsName);
    }

    @OnClick({R.id.img_back})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.img_back:
                onBackPressed();
                break;
        }
    }
}
