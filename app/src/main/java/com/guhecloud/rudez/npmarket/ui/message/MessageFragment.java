package com.guhecloud.rudez.npmarket.ui.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.adapter.NoticeAdapter;
import com.guhecloud.rudez.npmarket.adapter.TodoAdapter;
import com.guhecloud.rudez.npmarket.adapter.WarningAdapter;
import com.guhecloud.rudez.npmarket.base.RxFragment;
import com.guhecloud.rudez.npmarket.mvp.contract.MsgFragmentContract;
import com.guhecloud.rudez.npmarket.mvp.model.NoticeMsgObj;
import com.guhecloud.rudez.npmarket.mvp.model.TodoMsgObj;
import com.guhecloud.rudez.npmarket.mvp.model.WarningMsgObj;
import com.guhecloud.rudez.npmarket.mvp.presenter.MsgFragmentPresenter;
import com.guhecloud.rudez.npmarket.util.ToastUtil;

import java.util.List;

import butterknife.BindView;

/**
 * Created by homework on 2019/3/5.
 */

public class MessageFragment extends RxFragment<MsgFragmentPresenter> implements MsgFragmentContract.View {
    private static final String POSITION = "position";
    private static final String TITLE = "TITLE";
    private int position;
    private String title;

    @BindView(R.id.rv_message)
    RecyclerView rv_message;

    int curPage=1,pageSize=10;
    int totlePage;

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
    protected void injectObject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_msg;
    }

    WarningAdapter warningAdapter;
    TodoAdapter todoAdapter;
    NoticeAdapter noticeAdapter;


    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        rv_message.setLayoutManager(new LinearLayoutManager(contextWeakReference.get()));
        if (position==0){//预警提醒
            warningAdapter = new WarningAdapter(R.layout.item_warning_msg);
            rv_message.setAdapter(warningAdapter);
            warningAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                }
            });
            warningAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                @Override
                public void onLoadMoreRequested() {
                    if (curPage<totlePage){

                        curPage++;
                        mPresenter.getWaningMsg(curPage,pageSize);
                    }else {
                        warningAdapter.loadMoreEnd();
                    }
                }
            },rv_message);

        }else if (position==1){//待办
            todoAdapter = new TodoAdapter(R.layout.item_todo_msg);
            rv_message.setAdapter(todoAdapter);
            todoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                }
            });
            todoAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                @Override
                public void onLoadMoreRequested() {
                    if (curPage<totlePage){
                        curPage++;
                        mPresenter.getTodoMsg(curPage,pageSize);
                    }else {
                        todoAdapter.loadMoreEnd();
                    }
                }
            },rv_message);

        }else if (position==2){//通知公告
            noticeAdapter = new NoticeAdapter(R.layout.item_notice_msg,contextWeakReference.get());
            rv_message.setAdapter(noticeAdapter);
            noticeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                }
            });
            noticeAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                @Override
                public void onLoadMoreRequested() {
                    if (curPage<totlePage){

                        curPage++;
                        mPresenter.getNoticeMsg(curPage,pageSize);
                    }else {
                        noticeAdapter.loadMoreEnd();
                    }
                }
            },rv_message);
        }
    }

    @Override
    protected void onLazyLoad() {
        ToastUtil.show(title);
        if (position==0){
            mPresenter.getWaningMsg(curPage,pageSize);
        }else if (position==1){
            mPresenter.getTodoMsg(curPage,pageSize);
        }else if (position==2){
            mPresenter.getNoticeMsg(curPage,pageSize);

        }
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void onWarningGet(WarningMsgObj warningMsgObj) {
        totlePage=warningMsgObj.pages;
        List<WarningMsgObj.WarningMsg> warningMsgs = warningMsgObj.records;
        if (curPage==1){
            warningAdapter.setNewData(warningMsgs);
        }else {
            warningAdapter.addData(warningMsgs);
        }
        if (warningMsgObj.pages==warningMsgObj.current){
            warningAdapter.loadMoreEnd();
        }else {
            warningAdapter.loadMoreComplete();
        }
    }

    @Override
    public void onTodoGet(TodoMsgObj todoMsgObj) {
        totlePage=todoMsgObj.pages;
        List<TodoMsgObj.TodoMsg> todoMsgs = todoMsgObj.records;
        if (curPage==1){
            todoAdapter.setNewData(todoMsgs);
        }else {
            todoAdapter.addData(todoMsgs);
        }
        if (todoMsgObj.pages==todoMsgObj.current){
            warningAdapter.loadMoreEnd();
        }else {
            warningAdapter.loadMoreComplete();
        }
    }

    @Override
    public void onNoticeGet(NoticeMsgObj noticeMsgObj) {
        totlePage=noticeMsgObj.pages;
        List<NoticeMsgObj.NoticeMsg> niticeMsgs = noticeMsgObj.records;
        if (curPage==1){
            noticeAdapter.setNewData(niticeMsgs);
        }else {
            noticeAdapter.addData(niticeMsgs);
        }
        if (noticeMsgObj.pages==noticeMsgObj.current){
            warningAdapter.loadMoreEnd();
        }else {
            warningAdapter.loadMoreComplete();
        }
    }
}
