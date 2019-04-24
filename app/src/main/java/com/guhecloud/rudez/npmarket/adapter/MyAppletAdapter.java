package com.guhecloud.rudez.npmarket.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.model.AppletModel;

import java.util.List;

/**
 * Created by homework on 2019/2/20.
 */

public class MyAppletAdapter extends BaseItemDraggableAdapter<AppletModel,BaseViewHolder> {
    Context context;
    boolean isEdit;

    public MyAppletAdapter(int layoutResId, List<AppletModel> data,Context context) {
        super(layoutResId, data);
        this.context=context;
    }


    @Override
    protected void convert(BaseViewHolder helper, AppletModel item) {

        TextView tv_name=helper.getView(R.id.tv_name);
        ImageView img_icon=helper.getView(R.id.img_icon);
        ImageView img_delete=helper.getView(R.id.img_delete);
        if (isEdit){
            img_delete.setVisibility(View.VISIBLE);
        }else {
            img_delete.setVisibility(View.GONE);
        }
        helper.addOnClickListener(R.id.img_delete);
        tv_name.setText(item.menuName);
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
