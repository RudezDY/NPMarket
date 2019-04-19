package com.guhecloud.rudez.npmarket.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guhecloud.rudez.npmarket.R;

import java.util.List;

/**
 * Created by homework on 2019/4/12.
 */

public class SearchHistoryAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    Context context;
    List<String> dataList;

    public SearchHistoryAdapter(Context context, int layoutResId) {
        super(layoutResId);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.search_text_tv, item);
//        LinearLayout layout = helper.getView(R.id.search_layout);
//        GradientDrawable drawable = new GradientDrawable();
//        drawable.setCornerRadius(8);
//        drawable.setColor(Color.rgb(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
//        layout.setBackground(drawable);
    }
}