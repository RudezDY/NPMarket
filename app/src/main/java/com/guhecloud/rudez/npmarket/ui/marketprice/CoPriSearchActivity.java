package com.guhecloud.rudez.npmarket.ui.marketprice;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.adapter.CoPriSearchAdapter;
import com.guhecloud.rudez.npmarket.base.RxActivity;
import com.guhecloud.rudez.npmarket.mvp.contract.CoPriSearchContract;
import com.guhecloud.rudez.npmarket.mvp.model.CoPriSearchObj;
import com.guhecloud.rudez.npmarket.mvp.presenter.CoPriSearchPresenter;
import com.guhecloud.rudez.npmarket.util.RxBus;

import butterknife.BindView;
import butterknife.OnClick;

public class CoPriSearchActivity extends RxActivity<CoPriSearchPresenter> implements CoPriSearchContract.View {

    @BindView(R.id.et_search)
    EditText et_search;
    @BindView(R.id.tv_search)
    TextView tv_search;
    @BindView(R.id.tv_searchNum)
    TextView tv_searchNum;
    @BindView(R.id.rv_search)
    RecyclerView rv_search;

    public static final int TYPE_GETGOODS=1;
    public static final int TYPE_GETMERCHANTBYGOODS=2;
    public static final int TYPE_GETGOODSBYTASK=3;

    int searchType;
    String searchKey;
    int curPage = 1;
    int pageSize = 10;
    int taskId,todoId;
    String offerId;

    CoPriSearchAdapter searchAdapter;

    @Override
    protected void injectObject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_co_pri_search;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {

        searchType=getIntent().getIntExtra("searchType",0);
        offerId=getIntent().getStringExtra("offerId");

        rv_search.setLayoutManager(new LinearLayoutManager(this));
        searchAdapter = new CoPriSearchAdapter(R.layout.item_getprice_search,searchType,this);
        rv_search.setAdapter(searchAdapter);

        searchAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                RxBus.getDefault().post(searchAdapter.getItem(position));
                finish();
            }
        });

        searchAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                curPage++;
                switch (searchType){
                    case 1:
                        mPresenter.getPriceGoods(curPage,pageSize,searchKey);
                        break;
                    case 2:
                        mPresenter.getMerchantByGoods(curPage,pageSize,offerId,searchKey);
                        break;
                    case 3:
//                        mPresenter.getGoodsByTask(taskId,todoId);
                        break;
                }
            }
        },rv_search);

        if (searchType==1){

        }else if (searchType==2){

        }else if (searchType==3){

        }

    }

    @OnClick({R.id.img_back,R.id.tv_search})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.img_back:
                onBackPressed();
                break;
            case R.id.tv_search:
                searchKey=et_search.getText().toString();
                switch (searchType){
                    case 1:
                        if (TextUtils.isEmpty(searchKey)){
                            break;
                        }
                        mPresenter.getPriceGoods(curPage,pageSize,searchKey);
                        break;
                    case 2:
                        mPresenter.getMerchantByGoods(curPage,pageSize,offerId,searchKey);
                        break;
                    case 3:
                        mPresenter.getGoodsByTask(taskId,todoId);
                        break;
                }
                break;
        }
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void onDataGet(CoPriSearchObj searchObj) {
        tv_searchNum.setText("找到"+searchObj.total+"个商品");
        if (curPage==1){
            searchAdapter.setNewData(searchObj.records);
        }else {
            searchAdapter.addData(searchObj.records);
        }
        if (searchObj.total<=searchAdapter.getItemCount()){
            searchAdapter.loadMoreEnd();
        }else {
            searchAdapter.loadMoreComplete();
        }
    }
}
