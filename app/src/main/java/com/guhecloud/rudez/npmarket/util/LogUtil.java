package com.guhecloud.rudez.npmarket.util;


import android.util.Log;

import com.guhecloud.rudez.npmarket.BuildConfig;
import com.orhanobut.logger.Logger;

/**
 * Created by codeest on 2016/8/3.
 */
public class LogUtil {

    public static boolean isDebug = BuildConfig.DEBUG;
    private static final String TAG = BuildConfig.APPLICATION_ID;

    public static void e(String tag,Object o) {
        if(isDebug) {
            Logger.e(tag, o);
        }
    }

    public static void e(Object o) {
        LogUtil.e(TAG,o);
    }

    public static void w(String tag,Object o) {
        if(isDebug) {
            Logger.w(tag, o);
        }
    }

    public static void w(Object o) {
        LogUtil.w(TAG,o);
    }

    public static void d(String msg) {
        if(isDebug) {
            Logger.d(msg);
        }
    }

    public static void i(String msg) {
        if(isDebug) {
            Logger.i(msg);
        }
    }

    public static void logTest1(){
        Log.i("测试测试测试","来了老弟");
    }
    public static void logTest2(){
        Log.i("测试测试测试","来了老姐");
    }
}
