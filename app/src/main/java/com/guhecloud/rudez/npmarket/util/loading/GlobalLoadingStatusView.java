package com.guhecloud.rudez.npmarket.util.loading;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.util.SystemUtil;

/**
 * Created by homework on 2019/4/11.
 */

@SuppressLint("ViewConstructor")
public class GlobalLoadingStatusView extends LinearLayout implements View.OnClickListener {

    private final TextView mTextView;
    private final Runnable mRetryTask;
    private final ImageView mImageView;

    public GlobalLoadingStatusView(Context context, Runnable retryTask) {
        super(context);
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER_HORIZONTAL);
        LayoutInflater.from(context).inflate(R.layout.view_global_loading_status, this, true);
        mImageView = findViewById(R.id.image);
        mTextView = findViewById(R.id.text);
        this.mRetryTask = retryTask;
        setBackgroundColor(0x44101010);
    }

    public void setMsgViewVisibility(boolean visible) {
        mTextView.setVisibility(visible ? VISIBLE : GONE);
    }

    public void setStatus(int status) {
        boolean show = true;
        View.OnClickListener onClickListener = null;
        int image = R.drawable.loading;
        String str = "";
        switch (status) {
            case Gloading.STATUS_LOAD_SUCCESS:
                show = false;
                break;
            case Gloading.STATUS_LOADING:
                str = "loading";
                break;
            case Gloading.STATUS_LOAD_FAILED:
                str = "loadingFailed";
                image = R.mipmap.ic_avatar;
                if (!SystemUtil.isNetworkConnected()) {
                    str = "notNetwork";
//                    image = R.drawable.icon_no_wifi;
                }
                onClickListener = this;
                break;
            case Gloading.STATUS_EMPTY_DATA:
                str = "empty";
//                image = R.drawable.icon_empty;
                break;
            default: break;
        }
        mImageView.setImageResource(image);
        setOnClickListener(onClickListener);
        mTextView.setText(str);
        setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onClick(View v) {
        if (mRetryTask != null) {

            mRetryTask.run();
        }
    }
}