package com.guhecloud.rudez.npmarket.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.guhecloud.rudez.npmarket.app.App;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Chanin on 2017/6/14.
 */
public abstract class BaseActivity extends AppCompatActivity {


    private Unbinder mUnBinder;
    public Activity activity;
    public WeakReference<Activity> activityWeakReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        activity = this;
        activityWeakReference = new WeakReference<Activity>(this);
        mUnBinder = ButterKnife.bind(this);
        App.getInstance().addActivity(activityWeakReference);
        initEventAndData(savedInstanceState);
    }




    protected abstract int getLayoutId();

    protected abstract void initEventAndData(Bundle savedInstanceState);




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
}
