package com.guhecloud.rudez.npmarket.di.module;

import android.app.Service;


import com.guhecloud.rudez.npmarket.di.scope.ServiceScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Chanin on 2017/6/14.
 */
@Module
public class ServiceMode {
    private Service mService;

    public ServiceMode(Service mService) {
        this.mService = mService;
    }
    @Provides
    @ServiceScope
    public Service provideService(){
        return mService;
    }
}
