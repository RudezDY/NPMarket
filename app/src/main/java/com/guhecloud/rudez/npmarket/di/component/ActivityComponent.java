package com.guhecloud.rudez.npmarket.di.component;

import android.app.Activity;


import com.guhecloud.rudez.npmarket.di.module.ActivityMode;
import com.guhecloud.rudez.npmarket.di.scope.AcitvityScope;
import com.guhecloud.rudez.npmarket.ui.contacts.ContactsActivity;
import com.guhecloud.rudez.npmarket.ui.menumanager.MenuManagerActivity;

import dagger.Component;

/**
 * Created by Chanin on 2017/6/14.
 */
@AcitvityScope
@Component(dependencies = AppComponent.class, modules = ActivityMode.class)
public interface ActivityComponent {
    Activity getActivity();


    void Inject(ContactsActivity contactsActivity);
    void Inject(MenuManagerActivity menuManagerActivity);

}
