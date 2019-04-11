package com.guhecloud.rudez.npmarket.ui.contacts;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.adapter.ContactsAdapter;
import com.guhecloud.rudez.npmarket.mvp.contract.ContactsContract;
import com.guhecloud.rudez.npmarket.mvp.model.ContactModel;
import com.guhecloud.rudez.npmarket.mvp.presenter.ContactsPresenter;
import com.guhecloud.rudez.npmarket.ui.main.HomeBaseActivity;
import com.guhecloud.rudez.npmarket.util.LogUtil;
import com.guhecloud.rudez.npmarket.util.ToastUtil;
import com.guhecloud.rudez.npmarket.widgit.wavesidebar.SearchEditText;
import com.guhecloud.rudez.npmarket.widgit.wavesidebar.Trans2PinYinUtil;
import com.guhecloud.rudez.npmarket.widgit.wavesidebar.WaveSideBarView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ContactsActivity extends HomeBaseActivity<ContactsPresenter> implements ContactsContract.View {

    @BindView(R.id.bar_side)
    WaveSideBarView bar_side;
    @BindView(R.id.et_search)
    SearchEditText et_search;
    @BindView(R.id.rv_contacts)
    RecyclerView rv_contacts;

    List<ContactModel> contactList;
    List<ContactModel> showData;
    ContactsAdapter contactsAdapter;


    @Override
    protected void injectObject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_contacts;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        initRv();
        setSide_Search();


    }

    @OnClick({R.id.img_menu})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.img_menu:
                startAty(DepartmentListActivity.class);
                break;
        }
    }

    private void setSide_Search() {
        // 侧边设置相关
        bar_side.setOnSelectIndexItemListener(new WaveSideBarView.OnSelectIndexItemListener() {
            @Override
            public void onSelectIndexItem(String letter) {
                for (int i=0; i<contactList.size(); i++) {
                    if (contactList.get(i).getIndex().equals(letter)) {
                        ((LinearLayoutManager) rv_contacts.getLayoutManager()).scrollToPositionWithOffset(i, 0);
                        return;
                    }
                }
            }
        });


        // 搜索按钮相关
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                showData.clear();
                for (ContactModel model : contactList) {
                    String str = Trans2PinYinUtil.trans2PinYin(model.getName());
                    if (str.contains(s.toString()) || model.getName().contains(s.toString())) {
                        showData.add(model);
                    }
                }
                contactsAdapter.setNewData(showData);
            }
        });
    }

    private void initRv() {
        showData=new ArrayList<>();
        contactList= ContactModel.getContacts();
        showData.addAll(contactList);
        rv_contacts.setLayoutManager(new LinearLayoutManager(this));
        contactsAdapter=new ContactsAdapter(R.layout.item_contact,showData,this);
        final PinnedHeaderDecoration decoration = new PinnedHeaderDecoration();
        decoration.registerTypePinnedHeader(1, new PinnedHeaderDecoration.PinnedHeaderCreator() {
            @Override
            public boolean create(RecyclerView parent, int adapterPosition) {
                return true;
            }
        });
        rv_contacts.addItemDecoration(decoration);
        rv_contacts.setAdapter(contactsAdapter);

        contactsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtil.shortShow(showData.get(position).getName());
            }
        });
        //监听rv的滑动，获取界面第一个显示的item
        rv_contacts.addOnScrollListener(new RecyclerView.OnScrollListener() {

            //滚动停止才进入
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            //滚动过程就算
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //获取界面第一个显示的item
                RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();//获取LayoutManager
                int topPOsition=((LinearLayoutManager)manager).findFirstVisibleItemPosition();
                LogUtil.i("topPosition:"+topPOsition);
                if (topPOsition < 0){
                    return;
                }
                String po=showData.get(topPOsition).getIndex();
                //设置侧边菜单栏选中位置
                bar_side.setCurPosition(po);
            }
        });

    }


    @Override
    public void showError(String msg) {

    }
}
