package com.guhecloud.rudez.npmarket.ui.main;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.base.BasePresenter;
import com.guhecloud.rudez.npmarket.base.RxActivity;
import com.guhecloud.rudez.npmarket.ui.contacts.ContactsActivity;
import com.guhecloud.rudez.npmarket.ui.message.MessageActivity;
import com.guhecloud.rudez.npmarket.ui.mine.MineActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by homework on 2019/2/22.
 */

public abstract class HomeBaseActivity<T extends BasePresenter> extends RxActivity<T> {

    @BindView(R.id.layout_tab0)
    LinearLayout layout_tab0;
    @BindView(R.id.layout_tab1)
    LinearLayout layout_tab1;
    @BindView(R.id.layout_tab2)
    LinearLayout layout_tab2;
    @BindView(R.id.layout_tab3)
    LinearLayout layout_tab3;
    @BindView(R.id.icon_0)
    ImageView icon_0;
    @BindView(R.id.icon_1)
    ImageView icon_1;
    @BindView(R.id.icon_2)
    ImageView icon_2;
    @BindView(R.id.icon_3)
    ImageView icon_3;
    @BindView(R.id.tv_tab_home)
    CheckedTextView tv_tab_home;
    @BindView(R.id.tv_tab_msg)
    CheckedTextView tv_tab_msg;
    @BindView(R.id.tv_tab_contacts)
    CheckedTextView tv_tab_contacts;
    @BindView(R.id.tv_tab_mine)
    CheckedTextView tv_tab_mine;


    @Override
    protected void onResume() {
        super.onResume();
        String name=activityWeakReference.get().getLocalClassName();
        if (name.contains("MainActivity")){
            icon_0.setImageLevel(1);
            tv_tab_home.setChecked(true);
        }
        if (name.contains("MessageActivity")){
            icon_1.setImageLevel(1);
            tv_tab_msg.setChecked(true);
        }
        if (name.contains("ContactsActivity")){
            icon_2.setImageLevel(1);
            tv_tab_contacts.setChecked(true);
        }
        if (name.contains("MineActivity")){
            icon_3.setImageLevel(1);
            tv_tab_mine.setChecked(true);
        }
    }

    @OnClick({R.id.layout_tab0,R.id.layout_tab1,R.id.layout_tab2,R.id.layout_tab3})
    public void onTabClick(View v){//处理tab栏点击事件
        String name=activityWeakReference.get().getLocalClassName();
        switch (v.getId()){
            case R.id.layout_tab0:
                if (name.contains("MainActivity"))
                    break;
                startAty(MainActivity.class);

                break;
            case R.id.layout_tab1:
                if (name.contains("MessageActivity"))
                    break;
                startAty(MessageActivity.class);
                if (!name.contains("MainActivity"))
                    finish();
                break;
            case R.id.layout_tab2:
                if (name.contains("ContactsActivity"))
                    break;;
                startAty(ContactsActivity.class);
                if (!name.contains("MainActivity"))
                    finish();
                break;
            case R.id.layout_tab3:
                if (name.contains("MineActivity"))
                    break;
                startAty(MineActivity.class);
                if (!name.contains("MainActivity"))
                    finish();
                break;
        }
    }


}
