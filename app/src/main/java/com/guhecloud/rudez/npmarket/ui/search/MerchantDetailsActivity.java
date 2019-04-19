package com.guhecloud.rudez.npmarket.ui.search;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.base.BaseActivity;
import com.guhecloud.rudez.npmarket.util.SystemUtil;

import butterknife.BindView;

public class MerchantDetailsActivity extends BaseActivity {

    @BindView(R.id.rv_booth)
    RecyclerView rv_booth;
    @BindView(R.id.rv_stock)
    RecyclerView rv_stock;
    @BindView(R.id.view_scroll)
    NestedScrollView view_scroll;
    //    @BindView(R.id.layout_title)
//    LinearLayout layout_title;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_merchant_details;
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
        rv_booth.setLayoutManager(layoutManager);
//        rv_stock.setLayoutManager(layoutManager);

    }
}
