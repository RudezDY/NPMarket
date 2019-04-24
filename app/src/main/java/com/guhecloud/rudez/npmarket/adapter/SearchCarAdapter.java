package com.guhecloud.rudez.npmarket.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.model.CarListObj;

/**
 * Created by homework on 2019/4/22.
 */

public class SearchCarAdapter extends BaseQuickAdapter<CarListObj.CarObj,BaseViewHolder> {
    Context context;
//    List<CarListObj.CarObj> data;

    public SearchCarAdapter(int layoutResId, Context context) {
        super(layoutResId);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, CarListObj.CarObj item) {
        ImageView img_icon=helper.getView(R.id.img_icon);
        helper.setText(R.id.tv_carNum,item.code);
        helper.setText(R.id.tv_carType,item.carTypeName);
    }

}
