package com.guhecloud.rudez.npmarket.mvp.presenter;


import com.guhecloud.rudez.npmarket.base.RxPresenter;
import com.guhecloud.rudez.npmarket.commonmodel.http.HttpHelper;
import com.guhecloud.rudez.npmarket.http.HttpCallBack;
import com.guhecloud.rudez.npmarket.http.HttpUtil;
import com.guhecloud.rudez.npmarket.mvp.contract.ContactsContract;

import javax.inject.Inject;


public class ContactsPresenter extends RxPresenter<ContactsContract.View> implements ContactsContract.Presenter {

    HttpHelper httpHelper;
    @Inject
    public ContactsPresenter(HttpHelper httpHelper) {
        this.httpHelper=httpHelper;
    }

    public void getContacts(String deptId,String keyWord){
        HttpUtil.getBook(deptId,keyWord, new HttpCallBack() {
            @Override
            public void onSuccess(String result) {

            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    public void getDept(){
        HttpUtil.getDept(new HttpCallBack() {
            @Override
            public void onSuccess(String result) {

            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

}
