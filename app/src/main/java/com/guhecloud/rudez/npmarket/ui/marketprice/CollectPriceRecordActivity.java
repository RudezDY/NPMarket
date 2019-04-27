package com.guhecloud.rudez.npmarket.ui.marketprice;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.adapter.PriceRecordAdapter;
import com.guhecloud.rudez.npmarket.base.RxActivity;
import com.guhecloud.rudez.npmarket.mvp.contract.CollectPriceRecordContract;
import com.guhecloud.rudez.npmarket.mvp.model.PriceRecordObj;
import com.guhecloud.rudez.npmarket.mvp.model.WeekObj;
import com.guhecloud.rudez.npmarket.mvp.presenter.CollectPriceRecordPresenter;
import com.guhecloud.rudez.npmarket.widgit.bottomDialog.WeekListDialog;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class CollectPriceRecordActivity extends RxActivity<CollectPriceRecordPresenter>
        implements CollectPriceRecordContract.View {

    @BindView(R.id.img_back)
    ImageView img_back;
    @BindView(R.id.et_search)
    EditText et_search;
    @BindView(R.id.img_weekSellect)
    ImageView img_weekSellect;
    @BindView(R.id.rv_price_record)
    RecyclerView rv_price_record;

    int curPage = 1;
    int pageSize = 10;
    int totlePage;
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

        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s!=null && s.toString().length()>0){
                    searchKey=s.toString();
                    curPage=1;
                    mPresenter.getRecord(curPage,pageSize,startDate,endDate,goodsType,searchKey);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        rv_price_record.setLayoutManager(new LinearLayoutManager(this));
        priceRecordAdapter=new PriceRecordAdapter(R.layout.item_price_record,thisActivity);
        rv_price_record.setAdapter(priceRecordAdapter);
        priceRecordAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (curPage<totlePage){

                    curPage++;
                    mPresenter.getRecord(curPage,pageSize,startDate,endDate,goodsType,searchKey);
                }else {
                    priceRecordAdapter.loadMoreEnd();
                }
            }
        },rv_price_record);

        mPresenter.getRecord(curPage,pageSize,startDate,endDate,goodsType,searchKey);
    }

    @Override
    public void showError(String msg) {

    }

    @OnClick({R.id.img_back,R.id.img_weekSellect})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.img_back:
                onBackPressed();
                break;
            case R.id.img_weekSellect:
                mPresenter.getWeekList();
                break;
        }
    }

    @Override
    public void onRecordGet(PriceRecordObj recordObj) {
        totlePage=recordObj.pages;
        if (curPage==1)
            priceRecordAdapter.setNewData(recordObj.records);
        else
            priceRecordAdapter.addData(recordObj.records);

        if (recordObj.pages==recordObj.current)
            priceRecordAdapter.loadMoreEnd();
        else
            priceRecordAdapter.loadMoreComplete();
    }

    @Override
    public void onWeekListGet(List<WeekObj> weekList) {
        new WeekListDialog(this)
                .setNewData(weekList)
                .setOnWeekItemClickListener(new WeekListDialog.OnWeekItemClickListener() {
                    @Override
                    public void onClick(WeekObj weekObj) {
                        startDate = weekObj.startDate;
                        endDate=weekObj.endDate;
                        curPage=1;
                        mPresenter.getRecord(curPage,pageSize,startDate,endDate,goodsType,searchKey);
                    }
                }).show();
    }
}
