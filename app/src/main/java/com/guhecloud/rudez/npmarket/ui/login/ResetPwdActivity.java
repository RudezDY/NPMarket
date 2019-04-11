package com.guhecloud.rudez.npmarket.ui.login;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.base.BaseActivity;
import com.guhecloud.rudez.npmarket.widgit.ClearWriteEditText;

import butterknife.BindView;
import butterknife.OnClick;

public class ResetPwdActivity extends BaseActivity {
    @BindView(R.id.et_tel)
    ClearWriteEditText et_tel;
    @BindView(R.id.et_pwd)
    ClearWriteEditText et_pwd;
    @BindView(R.id.et_pwd_confirm)
    ClearWriteEditText et_pwd_confirm;
    @BindView(R.id.et_vertifyCode)
    ClearWriteEditText et_vertifyCode;
    @BindView(R.id.tv_getCode)
    TextView tv_getCode;

    boolean isCanGetCode = true;//是否处于能获取验证码状态
    CountDownTimer countDownTimer;//计时器

    @Override
    protected int getLayoutId() {
        return R.layout.activity_reset_pwd;
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
    }
    @OnClick({R.id.tv_getCode,R.id.btn_commit})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.tv_getCode:
                countDownTimer.start();
                break;
            case R.id.btn_commit:

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countDownTimer.cancel();
    }
}
