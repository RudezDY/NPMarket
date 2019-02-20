package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.mvp.contract.ScanContract;

import javax.inject.Inject;


public class ContactsPresenter extends RxPresenter<ScanContract.View> implements ScanContract.Presenter {


    @Inject
    public ContactsPresenter() {
    }


}
