package com.guhecloud.rudez.npmarket.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Chanin on 2017/6/14.
 */
public abstract class BaseFragment extends Fragment {


    protected View mView;
    protected WeakReference<Activity> activityWeakReference;
    protected WeakReference<Context> contextWeakReference;
    private Unbinder mUnBinder;
    protected boolean isFirstLoad = false;//是否第一次加载视图，默认为false，createView之后置为ture;

    @Override
    public void onAttach(Context context) {
        if (context instanceof Activity) {
            activityWeakReference = new WeakReference<Activity>((Activity) context);
        }
        contextWeakReference = new WeakReference<Context>(context);
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        activityWeakReference.clear();
        contextWeakReference.clear();
        super.onDetach();
    }

    public void finishActivity() {
        if (activityWeakReference.get() != null) {
            activityWeakReference.get().finish();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), container, false);
        mUnBinder = ButterKnife.bind(this, mView);
        isFirstLoad = true;//视图创建完成，将变量置为true
        if (getUserVisibleHint()) {//如果Fragment可见进行数据加载
            onLazyLoad();
            isFirstLoad = false;
        }
        return mView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isFirstLoad && isVisibleToUser) {//视图变为可见并且是第一次加载
            onLazyLoad();
            isFirstLoad = false;
        }

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initEventAndData(savedInstanceState);
    }



    @Override
    public void onDestroyView() {
        isFirstLoad =false;
        mUnBinder.unbind();
        mView = null;
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected abstract int getLayoutId();

    protected abstract void initEventAndData(Bundle savedInstanceState);

    protected abstract void onLazyLoad();
}
