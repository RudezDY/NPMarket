package com.guhecloud.rudez.npmarket.ui.marketprice;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.adapter.MarketPriceAdapter;
import com.guhecloud.rudez.npmarket.base.RxActivity;
import com.guhecloud.rudez.npmarket.mvp.contract.MarketPriceContract;
import com.guhecloud.rudez.npmarket.mvp.model.MarketPriceObj;
import com.guhecloud.rudez.npmarket.mvp.model.WeekObj;
import com.guhecloud.rudez.npmarket.mvp.presenter.MarketPricePresenter;
import com.guhecloud.rudez.npmarket.widgit.bottomDialog.WeekListDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MarketPriceActivity extends RxActivity<MarketPricePresenter>implements MarketPriceContract.View {

    @BindView(R.id.view_toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_date)
    TextView tv_date;
    @BindView(R.id.rv_marketPrice)
    RecyclerView rv_marketPrice;
    @BindView(R.id.btn_add)
    ImageButton btn_add;
    @BindView(R.id.tv_toolbarRight)
    TextView tv_toolbarRight;

    MarketPriceAdapter adapter;
    List<MultiItemEntity> dataList;
    @Override
    protected void injectObject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_market_price;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        setToolBar(toolbar,"市场行情",true);
        tv_toolbarRight.setText("采价记录");
        tv_toolbarRight.setVisibility(View.VISIBLE);

        rv_marketPrice.setLayoutManager(new LinearLayoutManager(thisActivity));
        adapter=new MarketPriceAdapter(dataList=new ArrayList<>());
        rv_marketPrice.setAdapter(adapter);


        mPresenter.getMarketPrice("","");
    }

    @OnClick({R.id.tv_date,R.id.tv_toolbarRight,R.id.btn_add})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.tv_date:
                mPresenter.getWeekList();
                break;
            case R.id.tv_toolbarRight:
                startAty(CollectPriceRecordActivity.class);
                break;
            case R.id.btn_add:
                startAty(CollectPriceActivity.class);
                break;
        }
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void onPriceGet(List<MarketPriceObj> list) {
        dataList.clear();
        for (MarketPriceObj obj:list){
            for (MarketPriceObj.PriceList price:obj.priceList){
                obj.addSubItem(price);
            }
            dataList.add(obj);
        }

        adapter.setNewData(dataList);
        adapter.expandAll();
    }

    @Override
    public void onWekListGet(List<WeekObj> weekList) {
        new WeekListDialog(this)
                .setNewData(weekList)
                .setOnWeekItemClickListener(new WeekListDialog.OnWeekItemClickListener() {
                    @Override
                    public void onClick(WeekObj weekObj) {
                        tv_date.setText(weekObj.startDate+"————"+weekObj.endDate);
                        mPresenter.getMarketPrice(weekObj.startDate,weekObj.endDate);
                    }
                })
                .show();
    }

}
