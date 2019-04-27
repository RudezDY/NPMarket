package com.guhecloud.rudez.npmarket.ui.marketprice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.base.BaseActivity;
import com.guhecloud.rudez.npmarket.http.HttpCallBack;
import com.guhecloud.rudez.npmarket.http.HttpUtil;
import com.guhecloud.rudez.npmarket.mvp.model.GoodsDetail;
import com.guhecloud.rudez.npmarket.mvp.model.WeekObj;
import com.guhecloud.rudez.npmarket.ui.search.SearchActivity;
import com.guhecloud.rudez.npmarket.util.RxBus;
import com.guhecloud.rudez.npmarket.widgit.bottomDialog.WeekListDialog;

import org.xutils.common.util.LogUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

public class FiltrateActivity extends BaseActivity {

    @BindView(R.id.view_toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_taskName)
    EditText et_taskName;
    @BindView(R.id.tv_goodsName)
    TextView tv_goodsName;
    @BindView(R.id.tv_date)
    TextView tv_date;
    @BindView(R.id.tv_toolbarRight)
    TextView tv_toolbarRight;

    String startDate,endDate,searchKey,taskName;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_filtrate;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        setToolBar(toolbar,"筛选",true);
        tv_toolbarRight.setText("完成");
        tv_toolbarRight.setVisibility(View.VISIBLE);


        RxBus.getDefault().toFlowable(GoodsDetail.class).subscribe(new Consumer<GoodsDetail>() {
            @Override
            public void accept(GoodsDetail goodsDetail) throws Exception {
                LogUtil.i(new Gson().toJson(goodsDetail));
            }
        });
    }


    @OnClick({R.id.tv_goodsName,R.id.tv_date,R.id.tv_toolbarRight})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.tv_goodsName:
                Intent intent = new Intent(this, SearchActivity.class);

                break;
            case R.id.tv_date:
                HttpUtil.getWeekList(new HttpCallBack() {
                    @Override
                    public void onSuccess(String result) {
                        List<WeekObj> weekList = new Gson().fromJson(result, new TypeToken<WeekObj>() {
                        }.getType());
                        new WeekListDialog(thisActivity)
                                .setNewData(weekList)
                                .setOnWeekItemClickListener(new WeekListDialog.OnWeekItemClickListener() {
                                    @Override
                                    public void onClick(WeekObj weekObj) {
                                        startDate=weekObj.startDate;
                                        endDate=weekObj.endDate;
                                        tv_date.setText(startDate+"————"+weekObj.endDate);
                                    }
                                })
                                .show();
                    }

                    @Override
                    public void onFailure(String error) {

                    }
                });
                break;
            case R.id.tv_toolbarRight:

                break;
        }

    }
}
