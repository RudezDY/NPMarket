package com.guhecloud.rudez.npmarket.ui.mine;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckedTextView;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.base.BaseActivity;
import com.guhecloud.rudez.npmarket.util.ToastUtil;
import com.guhecloud.rudez.npmarket.widgit.ClearWriteEditText;

import butterknife.BindView;
import butterknife.OnClick;

public class ChangePwdActivity extends BaseActivity {

    @BindView(R.id.view_toolbar)
    Toolbar toolbar;

    @BindView(R.id.et_pwd_old)
    ClearWriteEditText et_pwd_old;
    @BindView(R.id.et_pwd_new)
    ClearWriteEditText et_pwd_new;
    @BindView(R.id.et_pwd_confirm)
    ClearWriteEditText et_pwd_confirm;
    @BindView(R.id.btn_commit)
    CheckedTextView btn_commit;

    String pwdOld,pwdNew,pwdConfirm;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_change_pwd;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        setToolBar(toolbar,"修改密码",true);
        et_pwd_confirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length()>=8 && s.toString().trim().equals(et_pwd_new.getText().toString().trim())){
                    btn_commit.setChecked(true);
                }else {
                    btn_commit.setChecked(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @OnClick({R.id.btn_commit})
    public void onClck(View v){
        pwdOld = et_pwd_old.getText().toString().trim();
        pwdNew = et_pwd_new.getText().toString().trim();
        pwdConfirm = et_pwd_confirm.getText().toString().trim();

        if (pwdNew.length()<8||!pwdNew.equals(pwdConfirm)){
            ToastUtil.show("新密码不一致或密码长度不符合");
        }else {
            //todo
        }


    }
}
