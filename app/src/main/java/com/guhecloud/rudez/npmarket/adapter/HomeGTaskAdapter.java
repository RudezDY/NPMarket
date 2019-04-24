package com.guhecloud.rudez.npmarket.adapter;

import android.content.Context;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.model.GTask;

/**
 * Created by homework on 2019/4/23.
 */

public class HomeGTaskAdapter extends BaseQuickAdapter<GTask,BaseViewHolder> {
    Context context;
    public HomeGTaskAdapter(int layoutResId,Context context) {
        super(layoutResId);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, GTask item) {
        helper.setText(R.id.tv_typeName,item.todoTypeName);
        helper.setText(R.id.tv_content,item.todoContent);
        helper.setText(R.id.tv_time,item.applyDate);
        TextView tv_status = helper.getView(R.id.tv_status);
        if (item.state.equals("0")){
            tv_status.setText("未处理");
            tv_status.setTextColor(context.getResources().getColor(R.color.orange));
        }else if (item.state.equals("1")){
            tv_status.setText("已处理");
            tv_status.setTextColor(context.getResources().getColor(R.color.gray_999999));
        }
    }
}
