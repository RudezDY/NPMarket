package com.guhecloud.rudez.npmarket.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.model.NoticeMsgObj;
import com.guhecloud.rudez.npmarket.util.GlideApp;

/**
 * Created by homework on 2019/4/27.
 */

public class NoticeAdapter extends BaseQuickAdapter<NoticeMsgObj.NoticeMsg,BaseViewHolder> {
    Context context;
    public NoticeAdapter(int layoutResId,Context context) {
        super(layoutResId);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, NoticeMsgObj.NoticeMsg item) {
        ImageView img_pic = helper.getView(R.id.img_pic);
        GlideApp.with(context).load(item.noticeImgUrl).into(img_pic);
        helper.setText(R.id.tv_date,item.createdDate);
        helper.setText(R.id.tv_title,item.noticeTitle);
        helper.setText(R.id.tv_content,item.noticeContent);
        helper.setText(R.id.tv_time,item.createdDate);
        helper.setText(R.id.tv_status,item.readStatus);
    }
}
