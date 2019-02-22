package com.guhecloud.rudez.npmarket.di.component;

import android.app.Activity;


import com.guhecloud.rudez.npmarket.di.module.ActivityMode;
import com.guhecloud.rudez.npmarket.di.scope.AcitvityScope;
import com.guhecloud.rudez.npmarket.ui.contacts.ContactsActivity;
import com.guhecloud.rudez.npmarket.ui.main.MainActivity;
import com.guhecloud.rudez.npmarket.ui.menumanager.MenuManagerActivity;
import com.guhecloud.rudez.npmarket.ui.message.MessageActivity;
import com.guhecloud.rudez.npmarket.ui.mine.MineActivity;
import com.guhecloud.rudez.npmarket.ui.scan.ScanActivity;

import dagger.Component;

/**
 * Created by Chanin on 2017/6/14.
 */
@AcitvityScope
@Component(dependencies = AppComponent.class, modules = ActivityMode.class)
public interface ActivityComponent {
    Activity getActivity();


    void Inject(ScanActivity scanActivity);
    void Inject(ContactsActivity contactsActivity);
    void Inject(MenuManagerActivity menuManagerActivity);
    void Inject(MainActivity mainActivity);
    void Inject(MessageActivity messageActivity);
    void Inject(MineActivity mineActivity);

}
