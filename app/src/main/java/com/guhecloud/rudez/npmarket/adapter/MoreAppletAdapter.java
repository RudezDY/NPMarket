package com.guhecloud.rudez.npmarket.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.model.AppletModel;

import java.util.List;

/**
 * Created by homework on 2019/2/20.
 */

public class MoreAppletAdapter extends BaseQuickAdapter<AppletModel,BaseViewHolder>{
    Context context;
    List<AppletModel> data;
    boolean isEdit;

    public MoreAppletAdapter(int layoutResId, @Nullable List<AppletModel> data,Context context) {
        super(layoutResId, data);
        this.context=context;
        this.data=data;
    }

    public MoreAppletAdapter(int layoutResId,Context context) {
        super(layoutResId);
        this.context=context;
        this.data=data;
    }

    @Override
    protected void convert(BaseViewHolder helper, AppletModel item) {
        TextView tv_name=helper.getView(R.id.tv_name);
        ImageView img_icon=helper.getView(R.id.img_icon);
        ImageView img_add=helper.getView(R.id.img_add);
        if (isEdit){
            img_add.setVisibility(View.VISIBLE);
        }else {
            img_add.setVisibility(View.GONE);
        }
        helper.addOnClickListener(R.id.img_add);
        tv_name.setText(item.getAppName());
    }

    public void setEdit(){
        isEdit=true;
        notifyDataSetChanged();
    }

    public void setEditEnd(){
        isEdit=false;
        notifyDataSetChanged();
    }
}
