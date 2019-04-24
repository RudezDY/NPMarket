package com.guhecloud.rudez.npmarket.ui.marketprice;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.adapter.PriceRecordAdapter;
import com.guhecloud.rudez.npmarket.base.RxActivity;
import com.guhecloud.rudez.npmarket.mvp.contract.CollectPriceRecordContract;
import com.guhecloud.rudez.npmarket.mvp.model.PriceRecordObj;
import com.guhecloud.rudez.npmarket.mvp.presenter.CollectPriceRecordPresenter;

import butterknife.BindView;

public class CollectPriceRecordActivity extends RxActivity<CollectPriceRecordPresenter>
        implements CollectPriceRecordContract.View {

    @BindView(R.id.view_toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_price_record)
    RecyclerView rv_price_record;
    @BindView(R.id.img_menu)
    ImageView img_menu;

    int curPage = 1;
    int pageSize = 10;
    String startDate,endDate,goodsType,searchKey;

    PriceRecordAdapter priceRecordAdapter;

    @Override
    protected void injectObject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collect_price_record;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        setToolBar(toolbar,"采价记录",true);
        img_menu.setImageResource(R.mipmap.icon_menu);
        img_menu.setVisibility(View.VISIBLE);

        rv_price_record.setLayoutManager(new LinearLayoutManager(this));
        priceRecordAdapter=new PriceRecordAdapter(R.layout.item_price_record,thisActivity);
        rv_price_record.setAdapter(priceRecordAdapter);
        priceRecordAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                curPage++;
                mPresenter.getRecord(curPage,pageSize,startDate,endDate,goodsType,searchKey);
            }
        },rv_price_record);

        mPresenter.getRecord(curPage,pageSize,startDate,endDate,goodsType,searchKey);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void onRecordGet(PriceRecordObj recordObj) {

        if (curPage==1)
            priceRecordAdapter.setNewData(recordObj.records);
        else
            priceRecordAdapter.addData(recordObj.records);

        if (priceRecordAdapter.getItemCount()>=recordObj.total)
            priceRecordAdapter.loadMoreEnd();
        else
            priceRecordAdapter.loadMoreComplete();
    }
}
