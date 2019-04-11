package com.guhecloud.rudez.npmarket.di.component;

import android.app.Activity;

import com.guhecloud.rudez.npmarket.di.module.ActivityMode;
import com.guhecloud.rudez.npmarket.di.scope.AcitvityScope;
import com.guhecloud.rudez.npmarket.ui.contacts.ContactsActivity;
import com.guhecloud.rudez.npmarket.ui.login.LoginActivity;
import com.guhecloud.rudez.npmarket.ui.main.MainActivity;
import com.guhecloud.rudez.npmarket.ui.menumanager.MenuManagerActivity;
import com.guhecloud.rudez.npmarket.ui.message.MessageActivity;
import com.guhecloud.rudez.npmarket.ui.mine.MineActivity;
import com.guhecloud.rudez.npmarket.ui.mine.UserInfoActivity;
import com.guhecloud.rudez.npmarket.ui.scan.ScanActivity;
import com.guhecloud.rudez.npmarket.ui.search.SearchActivity;

import dagger.Component;

/**
 * Created by Chanin on 2017/6/14.
 */
@AcitvityScope
@Component(dependencies = AppComponent.class, modules = ActivityMode.class)
public interface ActivityComponent {
    Activity getActivity();


    void inject(ScanActivity scanActivity);
    void inject(ContactsActivity contactsActivity);
    void inject(MenuManagerActivity menuManagerActivity);
    void inject(MainActivity mainActivity);
    void inject(MessageActivity messageActivity);
    void inject(MineActivity mineActivity);
    void inject(LoginActivity loginActivity);
    void inject(UserInfoActivity userInfoActivity);
    void inject(SearchActivity searchActivity);

}
