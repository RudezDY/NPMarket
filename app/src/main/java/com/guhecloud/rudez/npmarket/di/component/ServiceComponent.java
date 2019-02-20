package com.guhecloud.rudez.npmarket.di.component;

import android.app.Service;


import com.guhecloud.rudez.npmarket.di.module.ServiceMode;
import com.guhecloud.rudez.npmarket.di.scope.ServiceScope;

import dagger.Component;

/**
 * Created by Chanin on 2017/6/14.
 */
@ServiceScope
@Component(dependencies=AppComponent.class,modules = ServiceMode.class)
public interface ServiceComponent {
    Service getService();


//    void inject(UpdateService updateService);

}
