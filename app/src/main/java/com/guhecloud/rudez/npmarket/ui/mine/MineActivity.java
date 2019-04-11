package com.guhecloud.rudez.npmarket.ui.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.contract.MineContract;
import com.guhecloud.rudez.npmarket.mvp.presenter.MinePresenter;
import com.guhecloud.rudez.npmarket.ui.main.HomeBaseActivity;
import com.guhecloud.rudez.npmarket.util.ToastUtil;
import com.guhecloud.rudez.npmarket.widgit.CircleImageView;

import butterknife.BindView;
import butterknife.OnClick;

public class MineActivity extends HomeBaseActivity<MinePresenter> implements MineContract.View {

    @BindView(R.id.img_avatar)
    CircleImageView img_avatar;
    @BindView(R.id.img_arrow)
    ImageView img_arrow;
    @BindView(R.id.layout_safety)
    LinearLayout layout_safety;
    @BindView(R.id.layout_auto)
    LinearLayout layout_auto;
    @BindView(R.id.layout_feedback)
    LinearLayout layout_feedback;
    @BindView(R.id.layout_about)
    LinearLayout layout_about;
    @BindView(R.id.tv_nickname)
    TextView tv_nickname;
    @BindView(R.id.tv_username)
    TextView tv_username;




    @Override
    protected void injectObject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {

    }

    @OnClick({R.id.img_avatar,R.id.img_arrow,R.id.layout_safety,R.id.layout_auto,R.id.layout_feedback,R.id.layout_about})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.img_avatar:
                startAty(UserInfoActivity.class);
                break;
            case R.id.img_arrow:
                startAty(UserInfoActivity.class);
                break;
            case R.id.layout_safety:

                break;
            case R.id.layout_auto:
                startAty(AutoSettingActivity.class);
                break;
            case R.id.layout_feedback:
                startAty(FeedbackActivity.class);
                break;
            case R.id.layout_about:
                startAty(AboutOurActivity.class);
                break;
        }

    }

    @Override
    public void showError(String msg) {
        ToastUtil.show(msg);
    }
}
