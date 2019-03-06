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
import com.guhecloud.rudez.npmarket.mvp.presenter.MessagePresenter;
import com.guhecloud.rudez.npmarket.ui.main.HomeBaseActivity;

import butterknife.BindView;

public class MessageActivity extends HomeBaseActivity<MessagePresenter> implements MessageContract.View {

    public static final String POSITON = "POSITION";
    public static final String[] title = {"预警提醒", "待办", "通知公告"};

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


        tab_message.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if (null == view) {
                    tab.setCustomView(R.layout.layout_msg_tab);
                }
                TextView textView = tab.getCustomView().findViewById(R.id.tv_msg_tab);
                textView.setText(title[tab.getPosition()]);
                textView.setTextColor(tab_message.getTabTextColors());
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                textView.setTextSize(26);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if (null == view) {
                    tab.setCustomView(R.layout.layout_msg_tab);
                }
                TextView textView = tab.getCustomView().findViewById(R.id.tv_msg_tab);
                textView.setText(title[tab.getPosition()]);
                textView.setTextSize(18);
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

    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return MessageFragment.newInstance(position, title[position]);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return title.length;
        }
    }

    @Override
    public void showError(String msg) {

    }
}
