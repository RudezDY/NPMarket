package com.guhecloud.rudez.npmarket.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.util.GlideApp;
import com.yanzhenjie.album.AlbumFile;

import java.util.List;

/**
 * Created by homework on 2019/4/10.
 */

public class PicPickAdapter extends BaseQuickAdapter<AlbumFile,BaseViewHolder> {

    Context context;
    List<AlbumFile> dataList;

    public PicPickAdapter(int layoutResId, @Nullable List<AlbumFile> data,Context context) {
        super(layoutResId, data);
        this.context=context;
        this.dataList=data;
    }

    public PicPickAdapter(@Nullable List<AlbumFile> data,Context context) {
        super(data);
        this.context=context;
        this.dataList=data;
    }

    public PicPickAdapter(int layoutResId,Context context) {
        super(layoutResId);
        this.context=context;
    }


    @Override
    protected void convert(BaseViewHolder helper, AlbumFile item) {
        ImageView img = helper.getView(R.id.img_pic);
        ImageView delete = helper.getView(R.id.img_delete);
        GlideApp.with(context).load(item.getPath()).centerCrop().into(img);
        helper.addOnClickListener(R.id.img_delete);
        delete.setVisibility(View.VISIBLE);
    }

}
