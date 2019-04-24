package com.guhecloud.rudez.npmarket.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.model.MerchantDetail;

/**
 * Created by homework on 2019/4/23.
 */

public class BoothAdapter extends BaseQuickAdapter<MerchantDetail.Booth,BaseViewHolder> {
    public BoothAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, MerchantDetail.Booth item) {
        helper.setText(R.id.tv_boothName,item.shopStallsName+"  "+item.regionName);
        helper.setText(R.id.tv_endTime,"租约到期时间："+item.endTime);
    }
}
