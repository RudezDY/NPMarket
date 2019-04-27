package com.guhecloud.rudez.npmarket.ui.message;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.contract.MessageContract;
import com.guhecloud.rudez.npmarket.mvp.model.MsgCountObj;
import com.guhecloud.rudez.npmarket.mvp.presenter.MessagePresenter;
import com.guhecloud.rudez.npmarket.ui.main.HomeBaseActivity;

import butterknife.BindView;

public class MessageActivity extends HomeBaseActivity<MessagePresenter> implements MessageContract.View {

    public static final String POSITON = "position";
    public static final String[] titles = {"预警提醒", "待办", "通知公告"};

    @BindView(R.id.view_toolbar)
    Toolbar viewToolbar;
    @BindView(R.id.tab_message)
    TabLayout tab_message;
    @BindView(R.id.viewpager_message)
    ViewPager viewpager_message;

    @Override
    protected void injectObject() {
    getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        int position;
        if(savedInstanceState!=null){
            position =savedInstanceState.getInt(POSITON);
        }else {
            position = getIntent().getIntExtra(POSITON, 0);
        }
        setToolBar(viewToolbar,"消息中心");
//        vpTask.setOffscreenPageLimit(title.length);

        mPresenter.getMsgCount();



        tab_message.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if (null == view) {
                    tab.setCustomView(R.layout.layout_msg_tab);
                }

                TextView tvName = tab.getCustomView().findViewById(R.id.tv_msg_tab);
                tvName.setText(titles[tab.getPosition()]);
                tvName.setTextColor(tab_message.getTabTextColors());
                tvName.setTypeface(Typeface.DEFAULT_BOLD);
                tvName.setTextSize(18);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if (null == view) {
                    tab.setCustomView(R.layout.layout_msg_tab);
                }
                TextView textView = tab.getCustomView().findViewById(R.id.tv_msg_tab);
                textView.setText(titles[tab.getPosition()]);
                textView.setTextSize(16);
                textView.setTypeface(Typeface.DEFAULT);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewpager_message.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        tab_message.setupWithViewPager(viewpager_message);
        viewpager_message.setCurrentItem(position);


    }

    @Override
    public void onMsgCountGet(MsgCountObj msgCountObj) {
//        LogUtil.logTest1();
//        for (int i = 0;i<titles.length;i++){
//            TabLayout.Tab tab = tab_message.getTabAt(i);
//            tab.setCustomView(R.layout.layout_msg_tab);
//            TextView tvNum = tab.getCustomView().findViewById(R.id.tv_tab_num);
//            TextView tvName = tab.getCustomView().findViewById(R.id.tv_msg_tab);
//            tvName.setText(titles[tab.getPosition()]);
//
//            if (tvName.getText().toString().equals(titles[0])){
//                tvNum.setText(msgCountObj.warningCount+"");
//            }
//            else if (tvName.getText().toString().equals(titles[1])){
//                tvNum.setText(msgCountObj.unDealTodoCount+"");
//            }
//            else if (tvName.getText().toString().equals(titles[2])){
//                tvNum.setText(msgCountObj.unReadNoticeCount+"");
//            }
//
//        }
    }

    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return MessageFragment.newInstance(position, titles[position]);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return titles.length;
        }
    }

    @Override
    public void showError(String msg) {

    }
}
