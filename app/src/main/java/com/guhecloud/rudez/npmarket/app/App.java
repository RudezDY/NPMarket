package com.guhecloud.rudez.npmarket.app;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;


import com.guhecloud.rudez.npmarket.di.component.AppComponent;
import com.guhecloud.rudez.npmarket.di.component.DaggerAppComponent;
import com.guhecloud.rudez.npmarket.di.module.AppModule;
import com.guhecloud.rudez.npmarket.di.module.HttpModule;

import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Stack;

import javax.inject.Inject;


/**
 * Created by Chanin on 2017/6/9.
 */
public class App extends MultiDexApplication {

    private static final String TAG = "App";
    public static App instance;
    public static Stack<WeakReference<Activity>> activityStack = new Stack<>();


    public static int HEIGHTPIXELS;
    public static int WIDTHPIXELS;
    public static float DENSITY;
    public static int DENSITYDPI;
    private static AppComponent appComponent;


    public static AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent
                    .builder()
                    .appModule(new AppModule(App.getInstance()))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }





    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //测量屏幕尺寸
        getScreenSize();
        //在子线程中进行其他初始化
        //InitializeService.start(this);

        getAppComponent().Inject(this);



    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static  App getInstance() {
        return instance;
    }


    public void addActivity(WeakReference<Activity> activity) {
        activityStack.add(activity);
        Log.e(TAG,"addActivity : "+activityStack.size());
    }

    public void removeActivity(WeakReference<Activity>  activity) {

        if (activityStack.contains(activity)) {
            activityStack.remove(activity);
        }

        Log.e(TAG,"removeActivity : "+activityStack.size());
    }

    public void exitApp() {
        while (!activityStack.empty()) {
            WeakReference<Activity> activityWeakReference = activityStack.pop();
            if(activityWeakReference !=null&& activityWeakReference.get()!=null){
                activityWeakReference.get().finish();
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }


    public void getScreenSize() {
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            defaultDisplay.getRealMetrics(outMetrics);
        } else {
            defaultDisplay.getMetrics(outMetrics);
        }
        HEIGHTPIXELS = outMetrics.heightPixels;
        WIDTHPIXELS = outMetrics.widthPixels;
        DENSITY = outMetrics.density;
        DENSITYDPI = outMetrics.densityDpi;
    }


}