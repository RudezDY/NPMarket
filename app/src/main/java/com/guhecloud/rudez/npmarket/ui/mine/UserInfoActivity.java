package com.guhecloud.rudez.npmarket.ui.mine;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.base.RxActivity;
import com.guhecloud.rudez.npmarket.mvp.contract.UserInfoContract;
import com.guhecloud.rudez.npmarket.mvp.presenter.UserInfoPresenter;
import com.guhecloud.rudez.npmarket.widgit.CircleImageView;

import butterknife.BindView;
import butterknife.OnClick;

public class UserInfoActivity extends RxActivity<UserInfoPresenter> implements UserInfoContract.View {

    @BindView(R.id.view_toolbar)
    Toolbar view_toolbar;
    @BindView(R.id.img_avatar)
    CircleImageView img_avatar;
    @BindView(R.id.et_nikename)
    EditText et_nikename;
    @BindView(R.id.et_tel)
    EditText et_tel;
    @BindView(R.id.tv_toolbarRight)
    TextView tv_toolbarRight;

    boolean isEdit;

    @Override
    protected void injectObject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_info;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        setToolBar(view_toolbar,"个人资料",true);
        tv_toolbarRight.setVisibility(View.VISIBLE);
        setEdit();
    }

    private void setEdit() {
        tv_toolbarRight.setText("编辑");
        et_nikename.setEnabled(false);
        et_tel.setEnabled(false);
    }

    private void setSave() {
        tv_toolbarRight.setText("保存");
        et_nikename.setEnabled(true);
        et_tel.setEnabled(true);
    }

    @OnClick({R.id.tv_toolbarRight,R.id.img_avatar})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.img_avatar:
                if (isEdit){

                }else {
                    break;
                }

                break;
            case R.id.tv_toolbarRight:
                if (isEdit){
                    setEdit();
                }else {
                    setSave();
                }
                isEdit=!isEdit;
                break;
        }

    }

    @Override
    public void showError(String msg) {

    }
}
