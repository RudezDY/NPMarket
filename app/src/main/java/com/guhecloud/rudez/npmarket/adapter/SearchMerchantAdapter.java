package com.guhecloud.rudez.npmarket.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.model.MerchantListObj;

/**
 * Created by homework on 2019/4/22.
 */

public class SearchMerchantAdapter extends BaseQuickAdapter<MerchantListObj.MerchantObj,BaseViewHolder> {
    Context context;
//    List<CarListObj.CarObj> data;

    public SearchMerchantAdapter(int layoutResId, Context context) {
        super(layoutResId);
        this.context=context;
    }
    @Override
    protected void convert(BaseViewHolder helper, MerchantListObj.MerchantObj item) {
        ImageView img_icon=helper.getView(R.id.img_icon);
        helper.setText(R.id.tv_MerchantName,item.name);
        helper.setText(R.id.tv_type_booth,item.shopStallsName);
    }
}
