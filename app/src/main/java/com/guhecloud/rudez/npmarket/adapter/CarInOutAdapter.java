package com.guhecloud.rudez.npmarket.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.model.CarDetail;

/**
 * Created by homework on 2019/4/23.
 */

public class CarInOutAdapter extends BaseQuickAdapter<CarDetail.CarInOut,BaseViewHolder> {
    public CarInOutAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, CarDetail.CarInOut item) {
        helper.setText(R.id.tv_carInTime,item.entranceTime);
        helper.setText(R.id.tv_carOutTime,item.outTime);
    }
}
