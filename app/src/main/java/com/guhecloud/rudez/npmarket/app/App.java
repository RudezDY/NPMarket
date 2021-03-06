package com.guhecloud.rudez.npmarket.app;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import com.guhecloud.rudez.npmarket.BuildConfig;
import com.guhecloud.rudez.npmarket.di.component.AppComponent;
import com.guhecloud.rudez.npmarket.di.component.DaggerAppComponent;
import com.guhecloud.rudez.npmarket.di.module.AppModule;
import com.guhecloud.rudez.npmarket.di.module.HttpModule;
import com.guhecloud.rudez.npmarket.util.loading.Gloading;
import com.guhecloud.rudez.npmarket.util.loading.GlobalAdapter;

import org.xutils.x;

import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Stack;

import cn.jpush.android.api.JPushInterface;


/**
 * Created by Chanin on 2017/6/9.
 */
public class App extends MultiDexApplication {


    private static final String TAG = "App";
    public static App instance;
    public static Stack<WeakReference<Activity>> activityStack = new Stack<>();
    //为避免内存泄漏使用弱引用
    public WeakReference<Activity> mCurrentActivity;


    public static int HEIGHTPIXELS;
    public static int WIDTHPIXELS;
    public static float DENSITY;
    public static int DENSITYDPI;
    public static int STATUSBARHEIGHT;
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
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        closeAndroidPDialog();
        instance = this;
        //测量屏幕尺寸
        getScreenSize();
        //在子线程中进行其他初始化
        //InitializeService.start(this);

        Gloading.debug(BuildConfig.DEBUG);
        Gloading.initDefault(new GlobalAdapter());
        x.Ext.init(this);

        getAppComponent().Inject(this);
        setCurAty();


    }

    //获取当前Activity对象
    private void setCurAty() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated (Activity activity, Bundle bundle) {
                //do nothing
            }

            @Override
            public void onActivityStarted (Activity activity) {
                //do nothing
            }

            @Override
            public void onActivityResumed (Activity activity) {
                mCurrentActivity = new WeakReference<>(activity);
            }

            @Override
            public void onActivityPaused (Activity activity) {
                //do nothing
            }

            @Override
            public void onActivityStopped (Activity activity) {
                //do nothing
            }

            @Override
            public void onActivitySaveInstanceState (Activity activity, Bundle bundle) {
                //do nothing
            }

            @Override
            public void onActivityDestroyed (Activity activity) {
                //do nothing
            }
        });
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
    public void closeAllAty(){
        while (!activityStack.empty()) {
            WeakReference<Activity> activityWeakReference = activityStack.pop();
            if(activityWeakReference !=null&& activityWeakReference.get()!=null){
                activityWeakReference.get().finish();
            }
        }
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

        getStatusBarHeight();
    }

    /**
     * 获取状态栏高度
     * @return
     */
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        STATUSBARHEIGHT = result;
        return result;
    }

    /**
     * 去掉miui10之后的反射使用警告
     */
    private void closeAndroidPDialog(){
        try {
            Class aClass = Class.forName("android.content.pm.PackageParser$Package");
            Constructor declaredConstructor = aClass.getDeclaredConstructor(String.class);
            declaredConstructor.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Class cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread");
            declaredMethod.setAccessible(true);
            Object activityThread = declaredMethod.invoke(null);
            Field mHiddenApiWarningShown = cls.getDeclaredField("mHiddenApiWarningShown");
            mHiddenApiWarningShown.setAccessible(true);
            mHiddenApiWarningShown.setBoolean(activityThread, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}