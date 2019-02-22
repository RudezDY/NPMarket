package com.guhecloud.rudez.npmarket.ui.main;

import android.view.View;
import android.widget.LinearLayout;

import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.base.BasePresenter;
import com.guhecloud.rudez.npmarket.base.RxActivity;
import com.guhecloud.rudez.npmarket.ui.contacts.ContactsActivity;
import com.guhecloud.rudez.npmarket.ui.message.MessageActivity;
import com.guhecloud.rudez.npmarket.ui.mine.MineActivity;
import com.guhecloud.rudez.npmarket.util.LogUtil;

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


    @OnClick({R.id.layout_tab0,R.id.layout_tab1,R.id.layout_tab2,R.id.layout_tab3})
    public void onTabClick(View v){
        String name=activityWeakReference.get().getLocalClassName();
        switch (v.getId()){
            case R.id.layout_tab0:
                if (!name.contains("MainActivity"))
                    startAty(MainActivity.class);
                break;
            case R.id.layout_tab1:
                if (!name.contains("MessageActivity"))
                    startAty(MessageActivity.class);
                if (!name.contains("MainActivity"))
                    finish();
                break;
            case R.id.layout_tab2:
                if (!name.contains("ContactsActivity"))
                    startAty(ContactsActivity.class);
                if (!name.contains("MainActivity"))
                    finish();
                break;
            case R.id.layout_tab3:
                if (!name.contains("MineActivity"))
                    startAty(MineActivity.class);
                if (!name.contains("MainActivity"))
                    finish();
                break;
        }
    }

}
