package com.guhecloud.rudez.npmarket.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.contract.MainContract;
import com.guhecloud.rudez.npmarket.mvp.presenter.MainPresenter;
import com.nanchen.wavesidebar.SearchEditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends HomeBaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.img_scan)
    ImageView img_scan;
    @BindView(R.id.et_search)
    SearchEditText et_search;
    @BindView(R.id.banner)
    ConvenientBanner banner;

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
//        banner.setPages(
//                new CBViewHolderCreator() {
//                    @Override
//                    public LocalImageHolderView createHolder(View itemView) {
//                        return new LocalImageHolderView(itemView);
//                    }
//
//                    @Override
//                    public int getLayoutId() {
//                        return R.layout.item_localimage;
//                    }
//                }, localImages)
//                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
////                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
//                .setOnItemClickListener(this);
//        //设置指示器的方向
////                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
////                .setOnPageChangeListener(this)//监听翻页事件
//        ;

//        banner.setManualPageable(false);//设置不能手动影响

        //网络加载例子
        List<String> imgUrls=new ArrayList<>();
        imgUrls.add("http://d.5857.com/yushe_160219/005.jpg");
        imgUrls.add("http://old.bz55.com/uploads/allimg/141104/1-1411041K422.jpg");
        imgUrls.add("http://old.bz55.com/uploads/allimg/141104/1-1411041K425.jpg");
        imgUrls.add("http://up.enterdesk.com/edpic_360_360/1d/35/87/1d3587b3be79869936dc237bc0ecc119.jpg");
        imgUrls.add("http://www.xxthemes.com/article/UploadPic/2013-2/2013222238890171.jpg");
//        banner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
//            @Override
//            public NetworkImageHolderView createHolder() {
//                return new NetworkImageHolderView(LayoutInflater.from(MainActivity.this).inflate(R.layout.banner_item,null));
//            }
//        },imgUrls);
    }

    @Override
    public void showError(String msg) {

    }
}
