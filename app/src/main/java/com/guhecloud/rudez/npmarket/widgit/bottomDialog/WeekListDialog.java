package com.guhecloud.rudez.npmarket.widgit.bottomDialog;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.guhecloud.rudez.npmarket.R;
import com.guhecloud.rudez.npmarket.mvp.model.WeekObj;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by homework on 2019/4/24.
 */

public class WeekListDialog extends BottomDialogBase {
    Context context;

    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    @BindView(R.id.tv_tips)
    TextView tv_tips;

    WeekAdaper weekAdaper;

    public WeekListDialog(Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected int getContentView() {
        return R.layout.dialog_bottom_list;
    }

    @Override
    protected void initViewAndData() {
        ButterKnife.bind(this);
        tv_tips.setText("请选择");
        rv_list.setLayoutManager(new LinearLayoutManager(context));
        weekAdaper =new WeekAdaper(R.layout.item_weeklist);
        rv_list.setAdapter(weekAdaper);
        weekAdaper.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                onWeekItemClickListener.onClick(weekAdaper.getItem(position));
                dismiss();
            }
        });
    }

    public WeekListDialog setNewData(List<WeekObj> data){
        weekAdaper.setNewData(data);
        return this;
    }

    class WeekAdaper extends BaseQuickAdapter<WeekObj,BaseViewHolder>{

        public WeekAdaper(int layoutResId) {
            super(layoutResId);
        }

        @Override
        protected void convert(BaseViewHolder helper, WeekObj item) {
            helper.setText(R.id.tv_date,item.startDate+"————"+item.endDate);
        }
    }


    public WeekListDialog setOnWeekItemClickListener(OnWeekItemClickListener onWeekItemClickListener){
        this.onWeekItemClickListener = onWeekItemClickListener;
        return this;
    }

    public   OnWeekItemClickListener onWeekItemClickListener;
    public interface OnWeekItemClickListener {
        void onClick(WeekObj weekObj);
    }


}
