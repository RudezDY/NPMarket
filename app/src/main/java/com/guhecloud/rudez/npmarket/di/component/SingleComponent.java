package com.guhecloud.rudez.npmarket.di.component;


import com.guhecloud.rudez.npmarket.di.module.AppModule;
import com.guhecloud.rudez.npmarket.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by lenovo on 2018/1/5.
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface SingleComponent {

}
