package com.guhecloud.rudez.npmarket.di.module;

import android.os.UserManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.guhecloud.rudez.npmarket.app.App;
import com.guhecloud.rudez.npmarket.commonmodel.http.HttpHelper;
import com.guhecloud.rudez.npmarket.commonmodel.prefs.PrefsHelper;

import javax.inject.Singleton;
import javax.net.ssl.KeyManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Chanin on 2017/6/14.
 */
@Module
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return app;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().disableHtmlEscaping().create();
    }

    @Provides
    @Singleton
    PrefsHelper providePrefsHelper(App app, Gson gson){
        return new PrefsHelper(app,gson);
    }






}
