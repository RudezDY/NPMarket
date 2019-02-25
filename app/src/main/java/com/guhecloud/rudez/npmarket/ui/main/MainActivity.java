package com.guhecloud.rudez.npmarket.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.contract.MainContract;
import com.guhecloud.rudez.npmarket.mvp.presenter.MainPresenter;
import com.guhecloud.rudez.npmarket.util.GlideApp;
import com.guhecloud.rudez.npmarket.util.ToastUtil;
import com.nanchen.wavesidebar.SearchEditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.bingoogolapple.bgabanner.BGABanner;

public class MainActivity extends HomeBaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.img_scan)
    ImageView img_scan;
    @BindView(R.id.et_search)
    SearchEditText et_search;
    @BindView(R.id.banner_guide_content)
    BGABanner banner;

    @Override
    protected void injectObject() {
        getActivityComponent().Inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        banner.setAdapter(new BGABanner.Adapter<ImageView,String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, @Nullable String model, int position) {
                GlideApp.with(thisActivity).load(model).centerCrop().into(itemView);
            }
        });

        List<String> imgUrls=new ArrayList<>();
        imgUrls.add("http://d.5857.com/yushe_160219/005.jpg");
        imgUrls.add("http://old.bz55.com/uploads/allimg/141104/1-1411041K422.jpg");
        imgUrls.add("http://old.bz55.com/uploads/allimg/141104/1-1411041K425.jpg");
        imgUrls.add("http://up.enterdesk.com/edpic_360_360/1d/35/87/1d3587b3be79869936dc237bc0ecc119.jpg");
        imgUrls.add("http://www.xxthemes.com/article/UploadPic/2013-2/2013222238890171.jpg");
        List<String > tipsList = new ArrayList<>();
        for (int i=0;i<imgUrls.size();i++) {
            tipsList.add("pic"+i);
        }
        /**
         * 设置是否开启自动轮播，需要在 setData 方法之前调用，并且调了该方法后必须再调用一次 setData 方法
         * 例如根据图片当图片数量大于 1 时开启自动轮播，等于 1 时不开启自动轮播
         */
        banner.setAutoPlayAble(imgUrls.size()>1);
        banner.setAutoPlayInterval(3000);//间隔时间
        banner.setAspectRatio(20f/9);//设置宽高比，float类型
        banner.setData(imgUrls,tipsList);

        banner.setDelegate(new BGABanner.Delegate<ImageView,String>() {
            @Override
            public void onBannerItemClick(BGABanner banner, ImageView itemView, @Nullable String model, int position) {
                ToastUtil.shortShow("位置"+position+"  地址："+model);
            }
        });
    }

    @Override
    public void showError(String msg) {

    }
}
