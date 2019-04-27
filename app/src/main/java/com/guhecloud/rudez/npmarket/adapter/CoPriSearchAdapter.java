package com.guhecloud.rudez.npmarket.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.model.CoPriSearchObj;
import com.guhecloud.rudez.npmarket.ui.marketprice.CoPriSearchActivity;

/**
 * Created by homework on 2019/4/25.
 */

public class CoPriSearchAdapter extends BaseQuickAdapter<CoPriSearchObj.Record,BaseViewHolder> {

    int type;
    Context context;

    public CoPriSearchAdapter(int layoutResId,int type,Context context) {
        super(layoutResId);
        this.type = type;
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, CoPriSearchObj.Record item) {
        switch (type){
            case CoPriSearchActivity.TYPE_GETGOODS:
                helper.setText(R.id.tv_name,item.offerName);
                helper.setImageResource(R.id.img_icon,R.mipmap.icon_goods);
                break;
            case CoPriSearchActivity.TYPE_GETMERCHANTBYGOODS:
                helper.setText(R.id.tv_name,item.custName);
                helper.setImageResource(R.id.img_icon,R.mipmap.avatar);
                break;
            case CoPriSearchActivity.TYPE_GETGOODSBYTASK:
                helper.setText(R.id.tv_name,item.offerName);
                helper.setImageResource(R.id.img_icon,R.mipmap.icon_goods);
                break;
        }
    }
}
