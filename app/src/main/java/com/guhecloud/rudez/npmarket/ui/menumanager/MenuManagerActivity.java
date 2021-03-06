package com.guhecloud.rudez.npmarket.ui.menumanager;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.adapter.MoreAppletAdapter;
import com.guhecloud.rudez.npmarket.adapter.MyAppletAdapter;
import com.guhecloud.rudez.npmarket.base.RxActivity;
import com.guhecloud.rudez.npmarket.mvp.contract.MenuManagerContract;
import com.guhecloud.rudez.npmarket.mvp.model.AppletModel;
import com.guhecloud.rudez.npmarket.mvp.model.AppletObj;
import com.guhecloud.rudez.npmarket.mvp.presenter.MenuManagerPresenter;
import com.guhecloud.rudez.npmarket.util.LogUtil;
import com.guhecloud.rudez.npmarket.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MenuManagerActivity extends RxActivity<MenuManagerPresenter> implements MenuManagerContract.View, View.OnClickListener {

    @BindView(R.id.view_toolbar)
    Toolbar view_toolbar;
    @BindView(R.id.tv_toolbarRight)
    TextView tv_toolbarRight;


    @BindView(R.id.rv_myApps)
    RecyclerView rv_myApps;
    @BindView(R.id.rv_moreApps)
    RecyclerView rv_moreApps;


    List<AppletModel> allAppletData;
    List<AppletModel> myAppletData;
    List<AppletModel> moreAppletData;
    MyAppletAdapter myAppletAdapter;
    MoreAppletAdapter moreAppletAdapter;

    View footer;
    final String MANAGE = "编辑";
    final String COMPLETE = "保存";

    List<Integer> saveList;

    @Override
    protected void injectObject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_menu_manager;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        setToolBar(view_toolbar,"应用中心");
        tv_toolbarRight.setVisibility(View.VISIBLE);
        tv_toolbarRight.setText(MANAGE);
        saveList=new ArrayList<>();

        initRv();

        setRvClick();

        setDrag();

        mPresenter.getAppletInfo();
    }

    @OnClick({R.id.tv_toolbarRight})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.tv_toolbarRight:
                if (tv_toolbarRight.getText().toString().equals(MANAGE)){
                    setEdit();
                }else if (tv_toolbarRight.getText().toString().equals(COMPLETE)){
                    setEditEnd();
                    mPresenter.saveAppletInfo(saveList);
                }
        }
    }

    /**
     * 转换为编辑状态
     */
    private void setEdit() {
        tv_toolbarRight.setText(COMPLETE);
        myAppletAdapter.setEdit();
        moreAppletAdapter.setEdit();
        footer.setVisibility(View.INVISIBLE);
    }

    /**
     * 转换为编辑完成状态
     */
    private void setEditEnd() {
        tv_toolbarRight.setText(MANAGE);
        myAppletAdapter.setEditEnd();
        moreAppletAdapter.setEditEnd();
        footer.setVisibility(View.VISIBLE);
    }

    private void initRv() {
        if (allAppletData==null)
            allAppletData=new ArrayList<>();
        if (myAppletData==null)
            myAppletData=new ArrayList<>();
        if (moreAppletData==null)
            moreAppletData=new ArrayList<>();
//        allAppletData= AppletModel.getImitateData();
//        myAppletData=getMyappdata(allAppletData);
//        moreAppletData=getMoreappdata(allAppletData);
        rv_myApps.setLayoutManager(new GridLayoutManager(this,4));
        rv_moreApps.setLayoutManager(new GridLayoutManager(this,4));
        myAppletAdapter=new MyAppletAdapter(R.layout.item_applet_mine,new ArrayList<AppletModel>(),this);
        moreAppletAdapter=new MoreAppletAdapter(R.layout.item_applet_more,this);
        myAppletAdapter.openLoadAnimation();
        moreAppletAdapter.openLoadAnimation();
        rv_myApps.setAdapter(myAppletAdapter);
        rv_moreApps.setAdapter(moreAppletAdapter);

        //设置我的应用footer（添加按钮）

        footer = LayoutInflater.from(this).inflate(R.layout.footer_add,null);
        myAppletAdapter.addFooterView(footer);
        footer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEdit();

            }
        });
        myAppletAdapter.setFooterViewAsFlow(true);
    }


    /**
     * 设置rv点击事件“新增、删除、点击、长按等
     */
    private void setRvClick() {
        myAppletAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                setEdit();
                return true;
            }
        });
        moreAppletAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                setEdit();
                return true;
            }
        });

        //删除
        myAppletAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId()== R.id.img_delete){
                    AppletModel curModel=myAppletData.remove(position);
                    curModel.setCollect(false);
                    moreAppletData.add(curModel);
                    moreAppletAdapter.setNewData(moreAppletData);
                    myAppletAdapter.setNewData(myAppletData);
                    saveList.remove(position);
                }
            }
        });
        //添加
        moreAppletAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId()==R.id.img_add){
                    if (myAppletData.size()>=7){
                        ToastUtil.show("最多添加七个应用噢");
                        return;
                    }
                    AppletModel curModel=moreAppletData.remove(position);
                    curModel.setCollect(true);
                    myAppletData.add(curModel);
                    myAppletAdapter.setNewData(myAppletData);
                    moreAppletAdapter.setNewData(moreAppletData);
                    saveList.add(curModel.id);
                }
            }
        });
    }

    /**
     * 设置拖拽
     */
    private void setDrag() {
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(myAppletAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(rv_myApps);

        // 开启拖拽
        myAppletAdapter.enableDragItem(itemTouchHelper, R.id.img_icon, true);
        myAppletAdapter.setOnItemDragListener(new OnItemDragListener() {
            @Override
            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {
                LogUtil.d("开始位置："+pos);
            }

            @Override
            public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {

            }

            @Override
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {

                LogUtil.d("结束位置："+pos);
                //更新拖拽后的数据及顺序
                myAppletData=myAppletAdapter.getData();
                saveList.clear();
                for (AppletModel model:myAppletData
                     ) {
                    Log.i("顺序","name: "+model.menuName+"     id:"+model.id);
                    saveList.add(model.id);
                }
            }
        });
    }

    @Override
    public void showError(String msg) {

    }


    @Override
    public void onAppletGet(AppletObj appletObj) {
        myAppletData = appletObj.hasChooseList;
        moreAppletData = appletObj.noChooseList;
        myAppletAdapter.setNewData(myAppletData);
        moreAppletAdapter.setNewData(moreAppletData);

        saveList.clear();
        for (AppletModel model:myAppletData ) {
            saveList.add(model.id);
        }
    }
}
