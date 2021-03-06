package com.guhecloud.rudez.npmarket.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.app.App;
import com.guhecloud.rudez.npmarket.util.loading.Gloading;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Chanin on 2017/6/14.
 */
public abstract class BaseActivity extends AppCompatActivity {


    private Unbinder mUnBinder;
    public BaseActivity thisActivity;
    public WeakReference<Activity> activityWeakReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(getLayoutId());

        thisActivity = this;
//        ViewGroup rootView = (ViewGroup) thisActivity.getWindow().getDecorView().findViewById(android.R.id.content);
//        rootView.setPadding(0, App.STATUSBARHEIGHT, 0, 0);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            //5.0 以上直接设置状态栏颜色
//            thisActivity.getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }
        activityWeakReference = new WeakReference<Activity>(this);
        mUnBinder = ButterKnife.bind(this);
        App.getInstance().addActivity(activityWeakReference);
        initEventAndData(savedInstanceState);
    }





    protected abstract int getLayoutId();

    protected abstract void initEventAndData(Bundle savedInstanceState);

    protected void setToolBar(Toolbar toolbar, String title) {
        setToolBar(toolbar, title, true);
    }

    protected void setToolBar(Toolbar toolbar, String title, boolean back) {
        toolbar.setTitle(title);
        TextView tv_title=findViewById(R.id.tv_title);
//        tv_title.setText(title);
        setSupportActionBar(toolbar);
        if (back) {
            if(getSupportActionBar()==null){
                return;
            }
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        } else {
            if(getSupportActionBar()==null){
                return;
            }
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            toolbar.setNavigationOnClickListener(null);
        }
    }

    protected void startAty(Class aty){
        Intent intent=new Intent();
        intent.setClass(this,aty);
        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().removeActivity(activityWeakReference);
        mUnBinder.unbind();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }


    /**
     * loading相关
     */
    protected Gloading.Holder mHolder;

    /**
     * make a Gloading.Holder wrap with current activity by default
     * override this method in subclass to do special initialization
     */
    protected void initLoadingStatusViewIfNeed() {
        if (mHolder == null) {
            //bind status view to activity root view by default
            mHolder = Gloading.getDefault().wrap(this).withRetry(new Runnable() {
                @Override
                public void run() {
                    onLoadRetry();
                }
            });
        }
    }

    protected void onLoadRetry() {
        // override this method in subclass to do retry task
    }

    public void showLoading() {
        initLoadingStatusViewIfNeed();
        mHolder.showLoading();
    }

    public void showLoadSuccess() {
        initLoadingStatusViewIfNeed();
        mHolder.showLoadSuccess();
    }

    public void showLoadFailed() {
        initLoadingStatusViewIfNeed();
        mHolder.showLoadFailed();
    }

    public void showEmpty() {
        initLoadingStatusViewIfNeed();
        mHolder.showEmpty();
    }


}
