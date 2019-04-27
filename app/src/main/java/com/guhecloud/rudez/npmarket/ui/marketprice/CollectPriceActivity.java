package com.guhecloud.rudez.npmarket.ui.marketprice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.adapter.PicPickAdapter;
import com.guhecloud.rudez.npmarket.base.RxActivity;
import com.guhecloud.rudez.npmarket.mvp.contract.CollectPriceContract;
import com.guhecloud.rudez.npmarket.mvp.model.CoPriSearchObj;
import com.guhecloud.rudez.npmarket.mvp.model.PicObj;
import com.guhecloud.rudez.npmarket.mvp.presenter.CollectPricePresenter;
import com.guhecloud.rudez.npmarket.util.RxBus;
import com.guhecloud.rudez.npmarket.util.ToastUtil;
import com.guhecloud.rudez.npmarket.widgit.bottomDialog.AreaDialog;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

public class CollectPriceActivity extends RxActivity<CollectPricePresenter> implements CollectPriceContract.View {

    @BindView(R.id.view_toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_toolbarRight)
    TextView tv_toolbarRight;
    @BindView(R.id.tv_goodsName)
    TextView tv_goodsName;
    @BindView(R.id.tv_merchantName)
    TextView tv_merchantName;
    @BindView(R.id.tv_areaName)
    TextView tv_areaName;
    @BindView(R.id.tv_unit_high)
    TextView tv_unit_high;
    @BindView(R.id.tv_unit_mid)
    TextView tv_unit_mid;
    @BindView(R.id.tv_unit_low)
    TextView tv_unit_low;
    @BindView(R.id.et_hightPrice)
    EditText et_hightPrice;
    @BindView(R.id.et_middlePrice)
    EditText et_middlePrice;
    @BindView(R.id.et_lowPrice)
    EditText et_lowPrice;
    @BindView(R.id.rv_pic)
    RecyclerView rv_pic;

    String custId,custName,offerId,offerName,productAreaName,taskName,unit;
    int id,taskId,todoId;

    double maxPrice,midPrice,minPrice;
    PicPickAdapter adapter;
    ArrayList<AlbumFile> picList;

    List<PicObj> picUrls;

    CoPriSearchObj.Record goodsInfo;

    @Override
    protected void injectObject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collect_price;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {


        if (!TextUtils.isEmpty(getIntent().getStringExtra("goosName"))){//如果是从任务界面进入
            taskId=getIntent().getIntExtra("taskId",0);
            todoId=getIntent().getIntExtra("todoId",0);
            taskName=getIntent().getStringExtra("taskName");
            offerName=getIntent().getStringExtra("goosName");
            offerId=getIntent().getStringExtra("goosId");
            unit=getIntent().getStringExtra("unit");
            tv_goodsName.setClickable(false);
            setGoodsUI();
        }

        initPicRv();
        setToolBar(toolbar,"商品采价",true);
        tv_toolbarRight.setText("保存");
        tv_toolbarRight.setVisibility(View.VISIBLE);

        RxBus.getDefault().toFlowable(CoPriSearchObj.Record.class)
                .subscribe(new Consumer<CoPriSearchObj.Record>() {
                    @Override
                    public void accept(CoPriSearchObj.Record record) throws Exception {
                        if (!TextUtils.isEmpty(record.offerId)){//选择商品
                            offerId=record.offerId;
                            unit=record.unit;
                            offerName=record.offerName;
                            setGoodsUI();

                        }
                        if (!TextUtils.isEmpty(record.custId)){//选择商家
                            custId=record.custId;
                            custName=record.custName;
                            tv_merchantName.setText(custName);
                        }
                    }
                });
    }

    private void setGoodsUI() {
        tv_goodsName.setText(offerName);
        tv_unit_high.setText(unit);
        tv_unit_mid.setText(unit);
        tv_unit_low.setText(unit);
    }

    String maxPriceStr,midPriceStr,minPriceStr;

    @OnClick({R.id.tv_toolbarRight,R.id.tv_goodsName,R.id.tv_merchantName,R.id.tv_areaName})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.tv_toolbarRight:
                commit();
                break;
            case R.id.tv_goodsName:
                Intent intent=new Intent(thisActivity,CoPriSearchActivity.class);
                intent.putExtra("searchType",CoPriSearchActivity.TYPE_GETGOODS);
                startActivity(intent);
                break;
            case R.id.tv_merchantName:
                if (TextUtils.isEmpty(offerId)){
                    ToastUtil.show("您还没有选择商品");
                    break;
                }
                Intent intent1=new Intent(thisActivity,CoPriSearchActivity.class);
                intent1.putExtra("searchType",CoPriSearchActivity.TYPE_GETMERCHANTBYGOODS);
                intent1.putExtra("offerId",offerId);
                startActivity(intent1);
                break;
            case R.id.tv_areaName:
                new AreaDialog(this)
                        .setOnAreaClickListener(new AreaDialog.OnAreaClickListener() {
                            @Override
                            public void onClick(String area) {
                                productAreaName = area;
                                Log.i("地区",productAreaName);
                            }
                        })
                .show();
                break;
        }
    }

    private void commit() {
        if (picList.size()>0){
            List<File> files = new ArrayList<>();
            for (AlbumFile afile:picList
                    ) {
                File file=new File(afile.getPath());
                files.add(file);
            }
            mPresenter.upLoad(files);

        }else {


            comit();

        }

    }

    //提交采价
    private void comit() {
        maxPriceStr=et_hightPrice.getText().toString().trim();
        midPriceStr=et_middlePrice.getText().toString().trim();
        minPriceStr=et_lowPrice.getText().toString().trim();
        if (tv_toolbarRight.getText().toString().equals("保存")){
            if (TextUtils.isEmpty(offerId)||TextUtils.isEmpty(custId)||TextUtils.isEmpty(unit)||
                    TextUtils.isEmpty(productAreaName)||TextUtils.isEmpty(maxPriceStr)||
                    TextUtils.isEmpty(midPriceStr)||TextUtils.isEmpty(minPriceStr)){
                ToastUtil.show("数据填写还不完整");
                return;
            }
            maxPrice=new Double(maxPriceStr);
            midPrice=new Double(midPriceStr);
            minPrice=new Double(minPriceStr);
            mPresenter.commitPrice(id,custId,custName,offerId,offerName,productAreaName,maxPrice,midPrice,minPrice,
                    unit,picUrls,taskId,todoId,taskName);

        }
    }

    private void initPicRv() {
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
    @Override
    public void showError(String msg) {

    }

    @Override
    public void onUploadSuccess(List<PicObj> picUrls) {
        this.picUrls =picUrls;
        comit();
    }

    @Override
    public void onCommitSuccess() {
        finish();
        ToastUtil.show("上传成功");
    }
}
