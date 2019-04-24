package com.guhecloud.rudez.npmarket.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.model.PriceRecordObj;
import com.guhecloud.rudez.npmarket.util.GlideApp;

import java.util.List;

/**
 * Created by homework on 2019/4/24.
 */

public class PriceRecordAdapter extends BaseQuickAdapter<PriceRecordObj.Record,BaseViewHolder> {
    Context context;
    public PriceRecordAdapter(int layoutResId,Context context) {
        super(layoutResId);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, PriceRecordObj.Record item) {
        helper.setText(R.id.tv_date,item.createdDate);
        helper.setText(R.id.tv_goodsName,item.offerName);
        helper.setText(R.id.tv_merchantName,item.custName);
        helper.setText(R.id.tv_yieldly,"产地："+item.productAreaName);
        helper.setText(R.id.tv_price_hight,item.maxPrice+item.unit);
        helper.setText(R.id.tv_price_middle,item.midPrice+item.unit);
        helper.setText(R.id.tv_price_low,item.minPrice+item.unit);
        helper.setText(R.id.tv_taskNme,"采价任务："+item.taskName);
        helper.setText(R.id.tv_workerName,"采价人："+item.createdBy);
        helper.setText(R.id.tv_time,"采价时间："+item.createdDate);

        RecyclerView rv_pics=helper.getView(R.id.rv_pics);
        rv_pics.setLayoutManager(new GridLayoutManager(context,4));
        rv_pics.setAdapter(new PicAdapter(R.layout.item_picpick,item.pictures));

    }

    class PicAdapter extends BaseQuickAdapter<PriceRecordObj.PicUrl,BaseViewHolder>{
        public PicAdapter(int layoutResId, @Nullable List<PriceRecordObj.PicUrl> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, PriceRecordObj.PicUrl item) {
            ImageView pic = helper.getView(R.id.img_pic);
            GlideApp.with(context).load(item.pictureUrl).into(pic);
        }

    }
}
