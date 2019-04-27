package com.guhecloud.rudez.npmarket.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.model.TodoMsgObj;

/**
 * Created by homework on 2019/4/27.
 */

public class TodoAdapter extends BaseQuickAdapter<TodoMsgObj.TodoMsg,BaseViewHolder> {
    public TodoAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, TodoMsgObj.TodoMsg item) {
        helper.setText(R.id.tv_date,item.applyDate);
        helper.setText(R.id.tv_title,item.todoTypeName);
        helper.setText(R.id.tv_content,item.todoContent);
        helper.setText(R.id.tv_time,item.applyDate);
        helper.setText(R.id.tv_status,item.state);
    }
}
