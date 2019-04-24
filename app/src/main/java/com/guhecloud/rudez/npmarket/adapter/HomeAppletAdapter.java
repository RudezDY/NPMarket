package com.guhecloud.rudez.npmarket.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.model.AppletModel;
import com.guhecloud.rudez.npmarket.util.GlideApp;

/**
 * Created by homework on 2019/4/23.
 */

public class HomeAppletAdapter  extends BaseQuickAdapter<AppletModel,BaseViewHolder> {
    Context context;

    public HomeAppletAdapter(int layoutResId,Context context) {
        super(layoutResId);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, AppletModel item) {
        if (helper.getAdapterPosition()>7)
            return;

        ImageView img_icon=helper.getView(R.id.img_icon);
        if (helper.getAdapterPosition()==7){
            img_icon.setImageResource(R.mipmap.icon_more);
            helper.setText(R.id.tv_name,"全部");
        }else {
            helper.setText(R.id.tv_name,item.menuName);
            if (item.menuLogo!=null)
            GlideApp.with(context).load(item.menuLogo).centerCrop().into(img_icon);
        }
    }
}
