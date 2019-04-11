package com.guhecloud.rudez.npmarket.ui.mine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.adapter.PicPickAdapter;
import com.guhecloud.rudez.npmarket.base.BaseActivity;
import com.guhecloud.rudez.npmarket.util.ToastUtil;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class FeedbackActivity extends BaseActivity {

    @BindView(R.id.view_toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_pic)
    RecyclerView rv_pic;
    @BindView(R.id.et_content)
    EditText et_content;

    PicPickAdapter adapter;
    ArrayList<AlbumFile> picList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        setToolBar(toolbar,"意见反馈",true);
        initAdapter();
    }

    private void initAdapter() {
        picList = new ArrayList<>();
        adapter = new PicPickAdapter(R.layout.item_picpick,thisActivity);
        rv_pic.setLayoutManager(new GridLayoutManager(thisActivity,4));
        rv_pic.setAdapter(adapter);
        View footerView = LayoutInflater.from(thisActivity).inflate(R.layout.item_picpick,null);
        adapter.addFooterView(footerView);
        adapter.setFooterViewAsFlow(true);//设置footer不占满一整行
        footerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickPic();
            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.img_delete:
                        picList.remove(position);
                        adapter.setNewData(picList);
                        break;
                }
            }
        });
    }

    @OnClick({R.id.btn_commit})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_commit:

                break;
        }

    }

    public void pickPic(){
        Album.image(thisActivity)
                .multipleChoice()
                .camera(true)//启用拍照
                .columnCount(3)//每行显示数量
                .selectCount(6)//最大选择数量
                .checkedList(picList)//已选择的list
                .afterFilterVisibility(true)//已选择的是否显示
                .onResult(new Action<ArrayList<AlbumFile>>() {
                    @Override
                    public void onAction(int requestCode, @NonNull ArrayList<AlbumFile> result) {
                        picList = result;
                        adapter.setNewData(picList);
                    }
                })
                .onCancel(new Action<String>() {
                    @Override
                    public void onAction(int requestCode, @NonNull String result) {
                        ToastUtil.show(result);
                    }
                })
                .start();
    }

}
