package com.guhecloud.rudez.npmarket.di.component;

import android.os.UserManager;

import com.google.gson.Gson;
import com.guhecloud.rudez.npmarket.app.App;
import com.guhecloud.rudez.npmarket.commonmodel.http.HttpHelper;
import com.guhecloud.rudez.npmarket.commonmodel.prefs.PrefsHelper;
import com.guhecloud.rudez.npmarket.di.module.AppModule;
import com.guhecloud.rudez.npmarket.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Chanin on 2017/6/14.
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();

    Gson getGson();

    HttpHelper getHttpHelper();

    PrefsHelper getPrefsHelper();

    void Inject(App app);
}
