package com.guhecloud.rudez.npmarket.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.model.ContactModel;

import java.util.List;

/**
 * Created by homework on 2019/2/20.
 */

public class ContactsAdapter extends BaseQuickAdapter<ContactModel,BaseViewHolder> {
    Context context;
    List<ContactModel> data;

    public ContactsAdapter(int layoutResId, @Nullable List<ContactModel> data, Context context) {
        super(layoutResId, data);
        this.context = context;
        this.data=data;
    }

    @Override
    protected void convert(BaseViewHolder helper, ContactModel item) {
        ImageView img_avatar=helper.getView(R.id.iv_avatar);
        TextView tv_index = helper.getView(R.id.tv_index);
        TextView tv_name = helper.getView(R.id.tv_name);

        int position = helper.getLayoutPosition();

        Log.e(TAG, "onBindViewHolder: index:" +position);
        if (position == 0 || !data.get(position-1).getIndex().equals(item.getIndex())) {
            tv_index.setVisibility(View.VISIBLE);
            String text =item.getIndex();
            if (text.contains("\"") || text.contains("!"))
                text=text.substring(1);
            tv_index.setText(text);
        } else {
            tv_index.setVisibility(View.GONE);
        }
        tv_name.setText(item.getName());
    }
}
