package com.guhecloud.rudez.npmarket.widgit.bottomDialog;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.http.HttpCallBack;
import com.guhecloud.rudez.npmarket.http.HttpUtil;
import com.guhecloud.rudez.npmarket.mvp.model.AreaObj;
import com.guhecloud.rudez.npmarket.util.LogUtil;
import com.guhecloud.rudez.npmarket.util.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by homework on 2019/4/26.
 */

public class AreaDialog extends BottomDialogBase {
    Context context;

    @BindView(R.id.rv_area)
    RecyclerView rv_area;
    @BindView(R.id.tv_tips)
    TextView tv_tips;
    @BindView(R.id.tv_province)
    TextView tv_province;
    @BindView(R.id.tv_city)
    TextView tv_city;
    @BindView(R.id.tv_area)
    TextView tv_area;

    AreaAdaper areaAdaper;
    int areaType=1;
    String provinceId,cityid;
    String areaName;
    AreaObj areaObj;

    public AreaDialog(Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected int getContentView() {
        return R.layout.dialog_area;
    }

    @OnClick({R.id.tv_province,R.id.tv_city,R.id.tv_area,R.id.tv_complet})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.tv_province:
                areaType = 1;

                getProcince();
                break;
            case R.id.tv_city:
                areaType=2;
                getCity();
                break;
            case R.id.tv_area:
                areaType=3;
                getArea();
                break;
            case R.id.tv_complet:
                if (TextUtils.isEmpty(areaName)){
                    ToastUtil.show("你还没有选择地区");
                    break;
                }
                onAreaClickListener.onClick(areaName);
                dismiss();
                break;
        }

    }

    private void getProcince() {
        HttpUtil.getProvince(new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                LogUtil.logTest1();
                List<AreaObj> areaList=new Gson().fromJson(result,new TypeToken <List<AreaObj>>(){}.getType());
                LogUtil.logTest2();
                areaAdaper = new AreaAdaper(R.layout.item_area,areaList,1);
                rv_area.setAdapter(areaAdaper);
                setAdapterClick();
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    private void getCity() {
        if (TextUtils.isEmpty(provinceId)){
            ToastUtil.show("没有选择省级单位");
            return;
        }
        HttpUtil.getCity(provinceId, new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                List<AreaObj> areaList=new Gson().fromJson(result,new TypeToken <List<AreaObj>>(){}.getType());
                areaAdaper = new AreaAdaper(R.layout.item_area,areaList,2);
                rv_area.setAdapter(areaAdaper);
                setAdapterClick();
//                areaAdaper.setNewData(areaList);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    private void getArea() {
        if (TextUtils.isEmpty(cityid)){
            ToastUtil.show("没有选择市级单位");
            return;
        }
        HttpUtil.getArea(cityid, new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                List<AreaObj> areaList=new Gson().fromJson(result,new TypeToken <List<AreaObj>>(){}.getType());
                areaAdaper = new AreaAdaper(R.layout.item_area,areaList,3);
                rv_area.setAdapter(areaAdaper);
                setAdapterClick();
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    @Override
    protected void initViewAndData() {
        ButterKnife.bind(this);
        setCanceledOnTouchOutside(false);
        tv_tips.setText("产地");
        rv_area.setLayoutManager(new LinearLayoutManager(context));
//        areaAdaper=new AreaAdaper(R.layout.item_area,areaType);
//        rv_area.setAdapter(areaAdaper);
        getProcince();


    }

    private void setAdapterClick() {
        areaAdaper.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                areaObj = areaAdaper.getItem(position);
                switch (areaType){
                    case 1:
                        areaName= areaObj.provinceName;
                        provinceId = areaObj.provinceId;
                        tv_province.setText(areaName);
                        areaType=2;
                        getCity();
                        break;
                    case 2:
                        areaName = areaObj.cityName;
                        tv_city.setText(areaName);
                        cityid=areaObj.cityId;
                        areaType=3;
                        getArea();
                        break;
                    case 3:
                        areaName=areaObj.areaName;
                        tv_area.setText(areaName);

                        break;
                }

            }
        });
    }


    class AreaAdaper extends BaseQuickAdapter<AreaObj,BaseViewHolder> {

        int type;
        List<AreaObj> data;
        public AreaAdaper(int layoutResId,int type) {
            super(layoutResId);
            this.type=type;
        }

        public AreaAdaper(int layoutResId, @Nullable List<AreaObj> data, int type) {
            super(layoutResId, data);
            this.type = type;
            this.data = data;
        }

        @Override
        protected void convert(BaseViewHolder helper, AreaObj item) {
            switch (type){
                case 1:
                    helper.setText(R.id.tv_areaName,item.provinceName);
                    break;
                case 2:
                    helper.setText(R.id.tv_areaName,item.cityName);
                    break;
                case 3:
                    helper.setText(R.id.tv_areaName,item.areaName);
                    break;
            }

        }
    }


    public AreaDialog setOnAreaClickListener(OnAreaClickListener onAreaClickListener){
        this.onAreaClickListener = onAreaClickListener;
        return this;
    }

    public OnAreaClickListener onAreaClickListener;
    public interface OnAreaClickListener {
        void onClick(String area);
    }


}
