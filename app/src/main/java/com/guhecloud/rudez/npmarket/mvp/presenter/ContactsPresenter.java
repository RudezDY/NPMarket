package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.mvp.contract.ContactsContract;
import com.guhecloud.rudez.npmarket.mvp.contract.ScanContract;

import javax.inject.Inject;


public class ContactsPresenter extends RxPresenter<ContactsContract.View> implements ContactsContract.Presenter {


    @Inject
    public ContactsPresenter() {
    }


}
