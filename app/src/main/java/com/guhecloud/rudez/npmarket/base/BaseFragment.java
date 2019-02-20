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
    protected boolean isInitView = false;
    protected boolean isInitData = false;

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
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initEventAndData(savedInstanceState);
        isInitView =true;
    }



    @Override
    public void onDestroyView() {
        isInitView =false;
        isInitData = false;
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
}
