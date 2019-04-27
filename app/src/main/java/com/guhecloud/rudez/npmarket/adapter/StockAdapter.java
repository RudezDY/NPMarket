package com.guhecloud.rudez.npmarket.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.model.MerchantDetail;

/**
 * Created by homework on 2019/4/23.
 */

public class StockAdapter extends BaseQuickAdapter<MerchantDetail.GoodsEnter,BaseViewHolder> {
    public StockAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, MerchantDetail.GoodsEnter item) {
        helper.setText(R.id.tv_stockTime,item.enterDt);
        helper.setText(R.id.tv_stockNum,item.offerName+item.wgtD+item.unit);
    }
}
