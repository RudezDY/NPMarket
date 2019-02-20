package com.guhecloud.rudez.npmarket.commonmodel.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.guhecloud.rudez.npmarket.app.App;
import com.guhecloud.rudez.npmarket.util.LogUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Chanin on 2017-07-07.
 */
public class PrefsHelper {


    private Gson gson;


    private static final String SHAREDPREFERENCES_NAME = "mode_sp";


    private static final String USERNAME = "USERNAME";
    private static final String PASSWORD = "PASSWORD";

    //设置消息状态保存
    private static final String MSGNOTICE = "MSGNOTICE";//消息提醒
    private static final String VOICENOTICE = "VOICENOTICE";//声音提醒
    private static final String SHAKENOTICE = "SHAKENOTICE";//震动提醒
    //设置自动登录状态保存
    private static final String AUTOLOGIN = "AUTOLOGIN";
    //储存自动登录账号密码等信息
    private static final String AUTOLOGININFO = "AUTOLOGININFO";
    //储存搜索记录
    private static final String SEARCHHISTORY = "SEARCHHISTORY";

    public void saveAutoLogin(boolean bol){
        mSPrefs.edit().putBoolean(AUTOLOGIN,bol).apply();
    }

    public boolean getAutoLogin(){
        return mSPrefs.getBoolean(AUTOLOGIN,true);
    }

    public void saveMsgNotice(boolean bol){
        mSPrefs.edit().putBoolean(MSGNOTICE,bol).apply();
    }

    public boolean getMsgNotice(){
        return mSPrefs.getBoolean(MSGNOTICE,false);
    }

    public void saveVoiceNotice(boolean bol){
        mSPrefs.edit().putBoolean(VOICENOTICE,bol).apply();
    }

    public boolean getVoiceNotice(){
        return mSPrefs.getBoolean(VOICENOTICE,false);
    }

    public void saveShakeNotice(boolean bol){
        mSPrefs.edit().putBoolean(SHAKENOTICE,bol).apply();
    }

    public boolean getShakeNotice(){
        return mSPrefs.getBoolean(SHAKENOTICE,false);
    }


    private final SharedPreferences mSPrefs;


    public PrefsHelper(App app, Gson gson) {
        this.gson = gson;
        mSPrefs = app.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public String getUserName() {
        return mSPrefs.getString(USERNAME, null);
    }

    public String getPassword() {
        return mSPrefs.getString(PASSWORD, null);
    }

    public void saveUserName(String name) {
        mSPrefs.edit().putString(USERNAME, name).apply();
    }

    public void savePassword(String password) {
        mSPrefs.edit().putString(PASSWORD, password).apply();
    }


}
