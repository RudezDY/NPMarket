package com.guhecloud.rudez.npmarket.mvp.contract;

import com.guhecloud.rudez.npmarket.base.BasePresenter;
import com.guhecloud.rudez.npmarket.base.BaseView;
import com.guhecloud.rudez.npmarket.mvp.model.PicObj;

import java.util.List;

/**
 * Created by homework on 2019/4/25.
 */

public interface CollectPriceContract {

    interface View extends BaseView{

        void onUploadSuccess(List<PicObj> picUrls);

        void onCommitSuccess();
    }

    interface Presenter extends BasePresenter<View>{

    }
}
