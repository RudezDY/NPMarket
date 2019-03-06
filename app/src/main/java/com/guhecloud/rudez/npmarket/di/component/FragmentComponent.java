package com.guhecloud.rudez.npmarket.di.component;


import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;


import com.guhecloud.rudez.npmarket.di.module.FragmentModule;
import com.guhecloud.rudez.npmarket.di.scope.FragmentScope;
import com.guhecloud.rudez.npmarket.ui.message.MessageFragment;

import dagger.Component;

/**
 * Created by Chanin on 2017/6/14.
 */
@FragmentScope
@Component(dependencies = AppComponent.class,modules = FragmentModule.class)
public interface FragmentComponent {

    Fragment getFragment();

    Activity getActivity();

    Context getContext();

    void inject(MessageFragment messageFragment);

}
