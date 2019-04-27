package com.guhecloud.rudez.npmarket.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.model.WarningMsgObj;

/**
 * Created by homework on 2019/4/27.
 */

public class WarningAdapter extends BaseQuickAdapter<WarningMsgObj.WarningMsg,BaseViewHolder>{

    public WarningAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, WarningMsgObj.WarningMsg item) {
        helper.setText(R.id.tv_date,item.createdDate);
        helper.setText(R.id.tv_title,item.title);
        helper.setText(R.id.tv_content,item.content);
        helper.setText(R.id.tv_time,item.createdDate);
    }
}
