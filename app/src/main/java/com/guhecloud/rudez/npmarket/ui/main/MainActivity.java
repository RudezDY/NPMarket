package com.guhecloud.rudez.npmarket.ui.main;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.adapter.HomeAppletAdapter;
import com.guhecloud.rudez.npmarket.adapter.HomeGTaskAdapter;
import com.guhecloud.rudez.npmarket.mvp.contract.MainContract;
import com.guhecloud.rudez.npmarket.mvp.model.HomePageObj;
import com.guhecloud.rudez.npmarket.mvp.presenter.MainPresenter;
import com.guhecloud.rudez.npmarket.ui.marketprice.MarketPriceActivity;
import com.guhecloud.rudez.npmarket.ui.menumanager.MenuManagerActivity;
import com.guhecloud.rudez.npmarket.ui.scan.ScanActivity;
import com.guhecloud.rudez.npmarket.ui.search.SearchActivity;
import com.guhecloud.rudez.npmarket.util.GlideApp;
import com.guhecloud.rudez.npmarket.util.ToastUtil;
import com.guhecloud.rudez.npmarket.widgit.wavesidebar.SearchEditText;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;
import io.reactivex.functions.Consumer;

public class MainActivity extends HomeBaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.img_scan)
    ImageView img_scan;
    @BindView(R.id.et_search)
    SearchEditText et_search;
    @BindView(R.id.banner_guide_content)
    BGABanner banner;

    @BindView(R.id.rv_backlog)
    RecyclerView rv_backlog;
    @BindView(R.id.rv_apps)
    RecyclerView rv_apps;
    @BindView(R.id.layout_backlog)
    LinearLayout layout_backlog;

    HomeAppletAdapter appletAdapter;
    HomeGTaskAdapter gTaskAdapter;

    @Override
    protected void injectObject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        et_search.setFocusable(false);
        initRv();
        mPresenter.getHomePage();
        setBanner();
    }

    private void initRv() {
        rv_apps.setLayoutManager(new GridLayoutManager(this,4));
        rv_backlog.setLayoutManager(new LinearLayoutManager(this));
        appletAdapter=new HomeAppletAdapter(R.layout.item_applet_mine,this);
        gTaskAdapter=new HomeGTaskAdapter(R.layout.item_home_gtask,this);
        rv_apps.setAdapter(appletAdapter);
        rv_backlog.setAdapter(gTaskAdapter);
        gTaskAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
        appletAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (appletAdapter.getItem(position).menuName.equals("市场行情")){
                    startAty(MarketPriceActivity.class);
                }
            }
        });

        View appletFooter= LayoutInflater.from(this).inflate(R.layout.item_applet_mine,null);
        ImageView icon = appletFooter.findViewById(R.id.img_icon);
        TextView tv_name = appletFooter.findViewById(R.id.tv_name);
        icon.setImageResource(R.mipmap.icon_more);
        tv_name.setText("全部");
        appletAdapter.addFooterView(appletFooter);
        appletAdapter.setFooterViewAsFlow(true);
        appletFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAty(MenuManagerActivity.class);
            }
        });
    }

    @OnClick({R.id.tv_more,R.id.et_search,R.id.img_scan})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.tv_more:

                break;
            case R.id.et_search:
                startAty(SearchActivity.class);
                break;
            case R.id.img_scan:
                new RxPermissions(thisActivity).request(Manifest.permission.CAMERA)
                        .subscribe(new Consumer<Boolean>() {
                            @Override
                            public void accept(Boolean aBoolean) throws Exception {
                                if (aBoolean)
                                    startAty(ScanActivity.class);
                            }
                        });
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void setBanner() {
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
        banner.setAspectRatio(16f/9);//设置宽高比，float类型
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    /**
     * 获取到数据
     * @param homePageObj
     */
    @Override
    public void onHomePageGet(HomePageObj homePageObj) {
        appletAdapter.setNewData(homePageObj.applicationList);
        gTaskAdapter.setNewData(homePageObj.todoList);
    }
}
