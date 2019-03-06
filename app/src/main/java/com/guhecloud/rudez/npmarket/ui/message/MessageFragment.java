package com.guhecloud.rudez.npmarket.ui.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.base.RxFragment;
import com.guhecloud.rudez.npmarket.mvp.contract.MsgFragmentContract;
import com.guhecloud.rudez.npmarket.mvp.presenter.MsgFragmentPresenter;
import com.guhecloud.rudez.npmarket.util.ToastUtil;

import butterknife.BindView;

/**
 * Created by homework on 2019/3/5.
 */

public class MessageFragment extends RxFragment<MsgFragmentPresenter> implements MsgFragmentContract.View {
    private static final String POSITION = "POSITION";
    private static final String TITLE = "TITLE";
    private int position;
    private String title;

    @BindView(R.id.rv_message)
    RecyclerView rv_message;

    public MessageFragment() {
    }

    public static MessageFragment newInstance(int position, String title) {
        MessageFragment fragment = new MessageFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION, position);
        args.putString(TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(POSITION);
            title = getArguments().getString(TITLE);
        }
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()&& isInitView&& !isInitData) {
//            loadNewData();
            ToastUtil.show(title);
        }
    }

    @Override
    protected void injectObject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_msg;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {

    }

    @Override
    public void showError(String msg) {

    }
}
