package com.guhecloud.rudez.npmarket.ui.main;

import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.app.App;
import com.guhecloud.rudez.npmarket.util.ToastUtil;

/**
 * Created by homework on 2019/2/22.
 */

public class NetworkImageHolderView extends Holder<String> {
    ImageView img_banner;

    public NetworkImageHolderView(View itemView) {
        super(itemView);
    }

    @Override
    protected void initView(View itemView) {
        img_banner=itemView.findViewById(R.id.img_banner);
        img_banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ToastUtil.show();
            }
        });
    }

    @Override
    public void updateUI(String data) {
        Glide.with(App.getInstance().getApplicationContext()).load(data).into(img_banner);
    }
}
