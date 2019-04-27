package com.guhecloud.rudez.npmarket.mvp.contract;


import com.guhecloud.rudez.npmarket.base.BasePresenter;
import com.guhecloud.rudez.npmarket.base.BaseView;
import com.guhecloud.rudez.npmarket.mvp.model.NoticeMsgObj;
import com.guhecloud.rudez.npmarket.mvp.model.TodoMsgObj;
import com.guhecloud.rudez.npmarket.mvp.model.WarningMsgObj;

public interface MsgFragmentContract {

    interface View extends BaseView {

        void onWarningGet(WarningMsgObj warningMsgObj);

        void onTodoGet(TodoMsgObj todoMsgObj);

        void onNoticeGet(NoticeMsgObj noticeMsgObj);

    }


    interface Presenter extends BasePresenter<View> {

    }

}
