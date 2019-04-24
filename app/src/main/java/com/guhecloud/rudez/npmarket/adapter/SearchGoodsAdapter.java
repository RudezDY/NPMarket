package com.guhecloud.rudez.npmarket.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.model.GoodsListObj;

/**
 * Created by homework on 2019/4/22.
 */

public class SearchGoodsAdapter extends BaseQuickAdapter<GoodsListObj.GoodsObj,BaseViewHolder> {
    Context context;
//    List<CarListObj.CarObj> data;

    public SearchGoodsAdapter(int layoutResId, Context context) {
        super(layoutResId);
        this.context=context;
    }


    @Override
    protected void convert(BaseViewHolder helper, GoodsListObj.GoodsObj item) {
        ImageView img_icon=helper.getView(R.id.img_icon);
        helper.setText(R.id.tv_goodsName,item.offerName + (item.offerAlias==null?"":"    别名"+item.offerAlias));
        helper.setText(R.id.tv_merchantName,item.custName);
    }
}
