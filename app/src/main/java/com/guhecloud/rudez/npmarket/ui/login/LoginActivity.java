package com.guhecloud.rudez.npmarket.ui.login;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.base.RxActivity;
import com.guhecloud.rudez.npmarket.mvp.contract.LoginContract;
import com.guhecloud.rudez.npmarket.mvp.model.User;
import com.guhecloud.rudez.npmarket.mvp.presenter.LoginPresenter;
import com.guhecloud.rudez.npmarket.ui.main.MainActivity;
import com.guhecloud.rudez.npmarket.util.LogUtil;
import com.guhecloud.rudez.npmarket.widgit.ClearWriteEditText;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends RxActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.et_tel)
    ClearWriteEditText et_tel;
    @BindView(R.id.et_pwd)
    ClearWriteEditText et_pwd;
    @BindView(R.id.et_vertifyCode)
    ClearWriteEditText et_vertifyCode;
    @BindView(R.id.layout_vertifyCode)
    LinearLayout layout_vertifyCode;
    @BindView(R.id.layout_useCode)
    LinearLayout layout_useCode;
    @BindView(R.id.tv_getCode)
    TextView tv_getCode;
    @BindView(R.id.tv_useCode)
    TextView tv_useCode;
    @BindView(R.id.tv_resetPwd)
    TextView tv_resetPwd;
    @BindView(R.id.tv_usePwd)
    TextView tv_usePwd;
    @BindView(R.id.btn_login)
    CheckedTextView btn_login;

    boolean isCanGetCode = true;//是否处于能获取验证码状态
    CountDownTimer countDownTimer;//计时器

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        countDownTimer=new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv_getCode.setText("(" + (millisUntilFinished/1000 - 1) + ") 重新获取");
            }

            @Override
            public void onFinish() {
                tv_getCode.setText("获取验证码");
                isCanGetCode = true;
            }
        };

        //监听密码输入框超过8个字登录按钮变色
        et_pwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length()>=8){
                    btn_login.setChecked(true);
                }else {
                    btn_login.setChecked(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    @OnClick({R.id.tv_getCode,R.id.tv_useCode,R.id.tv_usePwd,R.id.btn_login,R.id.tv_resetPwd})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_usePwd://用密码登录
                setUsePwdLogin();
                break;
            case R.id.tv_useCode://用验证码登陆
                setUseCodeLogin();
                break;
            case R.id.tv_getCode://获取验证码
                LogUtil.i("getCode");
                if (isCanGetCode) {
                    LogUtil.i("CanGetCode");
                    countDownTimer.start();
                    isCanGetCode = false;
                }

                break;
            case R.id.tv_resetPwd://找回密码
                startAty(ResetPwdActivity.class);
                break;
            case R.id.btn_login://登录

                mPresenter.login("faircheng", "111");

                break;
        }
    }

    @Override
    public void onLoginSuccess(User user) {
        User.getInstance().setUser(user);
        startAty(MainActivity.class);
        activityWeakReference.get().finish();
    }


    private void setUseCodeLogin() {
        layout_vertifyCode.setVisibility(View.VISIBLE);
        tv_usePwd.setVisibility(View.VISIBLE);
        et_pwd.setVisibility(View.GONE);
        layout_useCode.setVisibility(View.GONE);
    }

    private void setUsePwdLogin() {
        layout_vertifyCode.setVisibility(View.GONE);
        tv_usePwd.setVisibility(View.GONE);
        et_pwd.setVisibility(View.VISIBLE);
        layout_useCode.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countDownTimer.cancel();
    }

    @Override
    protected void injectObject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void showError(String msg) {

    }


}
