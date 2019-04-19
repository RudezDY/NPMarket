package com.guhecloud.rudez.npmarket.ui.search;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.adapter.SearchHistoryAdapter;
import com.guhecloud.rudez.npmarket.base.RxActivity;
import com.guhecloud.rudez.npmarket.mvp.contract.SearchContract;
import com.guhecloud.rudez.npmarket.mvp.presenter.SearchPresenter;
import com.guhecloud.rudez.npmarket.util.LogUtil;
import com.guhecloud.rudez.npmarket.widgit.EditText_Clear;
import com.library.flowlayout.FlowLayoutManager;
import com.library.flowlayout.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

import static com.guhecloud.rudez.npmarket.util.SystemUtil.dp2px;

public class SearchActivity extends RxActivity<SearchPresenter> implements SearchContract.View {

    @BindView(R.id.tab_search)
    TabLayout tab_search;
    @BindView(R.id.rv_search)
    RecyclerView rv_search;
    @BindView(R.id.rv_history)
    RecyclerView rv_history;
    @BindView(R.id.et_search)
    EditText_Clear et_search;

    public final int TYPE_CAR = 111;
    public final int TYPE_GOODS = 222;
    public final int TYPE_MERCHANT = 333;
    public final int TYPE_BOOK = 444;
    public final int TYPE_NOTICE = 555;

    public final String[] titles = {"车辆", "商品", "客户","通讯录","通知公告"};
    public final int[] searchTypes = {TYPE_CAR, TYPE_GOODS, TYPE_MERCHANT,TYPE_BOOK,TYPE_NOTICE};
    public int searchType = TYPE_CAR;//默认搜索车辆
    public int curPage = 1;
    public int pageSize=10;
    SearchHistoryAdapter searchHistoryAdapter;

    public final int SHOW_HISTORY = 0;
    public final int SHOW_TAB_LIST = 1;

    @Override
    protected void injectObject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        initTab();
        initHistory();
        initSearchEdit();

    }

    private void initSearchEdit() {
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s!=null&&s.toString().length()>1){//搜索栏字数大于等于2开始搜索并展示tab
                    showView(SHOW_TAB_LIST);
                    mPresenter.search(searchType,curPage,pageSize,et_search.getText().toString());
                }else {
                    showView(SHOW_HISTORY);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @OnClick({R.id.img_clear,R.id.tv_search})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.img_clear://清空搜索历史
                mPresenter.clearHistory();
                break;
            case R.id.tv_search://搜索
                if (et_search.getText().toString()!=null && et_search.getText().toString().length()>0){
                    showView(SHOW_TAB_LIST);
                    mPresenter.search(searchType,curPage,pageSize,et_search.getText().toString());
                }
                break;
        }

    }

    //初始化搜索历史
    private void initHistory() {
        rv_history.setLayoutManager(new FlowLayoutManager());
        rv_history.addItemDecoration(new SpaceItemDecoration(dp2px(10)));
        searchHistoryAdapter=new SearchHistoryAdapter(thisActivity, R.layout.item_search_history);
        rv_history.setAdapter(searchHistoryAdapter);
        searchHistoryAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String search_str=searchHistoryAdapter.getItem(position);
                if (search_str!=null){
                    et_search.setText(search_str);
                    et_search.setSelection(search_str.length());
                }
            }
        });
        mPresenter.getSearchHistory();
    }

    //初始化tab
    private void initTab() {
        for (String title : titles){
            tab_search.addTab(tab_search.newTab().setText(title));
        }
        tab_search.setTabMode(TabLayout.MODE_FIXED);//设置tab为可横向滑动模式
        tab_search.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()>2){
                    showTipsDialog();
                    return;
                }
                curPage=1;//重置当前页
                //TODO 重置rv的adapter
                searchType = searchTypes[tab.getPosition()];//tab变换时设置对应的搜索type
                mPresenter.search(searchType,curPage,pageSize,et_search.getText().toString());
                LogUtil.d(searchType+"");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void showError(String msg) {

    }

    //搜索历史测试数据
    public List<String> getStrs(){
        ArrayList<String> strs = new ArrayList<>();
        for (int i = 0;i<16;i++){
            if (i%3==0)
                strs.add(new Random().nextInt(1000000)+"dada");
            else if (i%3==1)
                strs.add(new Random().nextInt(1000000000)+"dada");
            else if (i%3==2)
                strs.add(new Random().nextInt(1000)+"dada");
        }


        return strs;
    }

    //设置搜索历史和TAb的显示隐藏
    public void showView(int type){
        switch (type){
            case SHOW_HISTORY:
                rv_history.setVisibility(View.VISIBLE);
                tab_search.setVisibility(View.GONE);
                rv_search.setVisibility(View.GONE);
                break;
            case SHOW_TAB_LIST:
                rv_history.setVisibility(View.GONE);
                tab_search.setVisibility(View.VISIBLE);
                rv_search.setVisibility(View.VISIBLE);
                break;
        }
    }

    //获取搜索历史成功
    @Override
    public void onHistorySuccess(List<String> historyList) {
        if (historyList == null || historyList.size()<=0){//搜索历史为空时设置空布局
            TextView empty =new TextView(thisActivity);
            empty.setGravity(Gravity.CENTER_HORIZONTAL);
            empty.setText("这里空空如也~~");
            searchHistoryAdapter.setEmptyView(empty);
        }
        searchHistoryAdapter.setNewData(historyList);
    }

    public void showTipsDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(thisActivity);
        builder.setTitle("温馨提示")
                .setMessage("此界面暂未开放，敬请期待！")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tab_search.getTabAt(0).select();
                    }
                })
                .create().show();
    }
}
