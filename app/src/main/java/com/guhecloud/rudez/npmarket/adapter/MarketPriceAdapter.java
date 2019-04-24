package com.guhecloud.rudez.npmarket.adapter;

import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.model.MarketPriceObj;

import java.util.List;

/**
 * Created by homework on 2019/4/24.
 */

public class MarketPriceAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MarketPriceAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item_price_lv0);
        addItemType(TYPE_LEVEL_1, R.layout.item_price_lv1);
    }

    @Override
    protected void convert(final BaseViewHolder helper, MultiItemEntity item) {
        switch (helper.getItemViewType()){
            case TYPE_LEVEL_0:
                final MarketPriceObj item0 = (MarketPriceObj) item;
                helper.setText(R.id.tv_goodsType,item0.offerType+" ("+item0.unit+")");
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = helper.getAdapterPosition();
                        Log.d(TAG, "Level 0 item pos: " + pos);
                        if (item0.isExpanded()) {
                            collapse(pos);
                        } else {
//                            if (pos % 3 == 0) {
//                                expandAll(pos, false);
//                            } else {
                            expand(pos);
//                            }
                        }
                    }
                });
                break;
            case TYPE_LEVEL_1:
                final MarketPriceObj.PriceList item1 = (MarketPriceObj.PriceList) item;
                helper.setText(R.id.tv_goodsName,item1.offerName);
                helper.setText(R.id.tv_price_thisWeek,item1.avgPrice+"");
                helper.setText(R.id.tv_price_lastWeek,item1.lastAvgPrice+"");
                helper.setText(R.id.tv_change,item1.hb+"");
                helper.setText(R.id.tv_price_middle,item1.price0+"");
                break;
        }
    }
}
