package com.example.lin.myandroidapplication.ui.qijian;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.adapter.ShowAdapter;
import com.example.lin.myandroidapplication.base.BaseRecyclerActivity;
import com.example.lin.myandroidapplication.data.ActivityData;

import java.util.ArrayList;
import java.util.List;

public class QiJianViewListActivity extends BaseRecyclerActivity<ActivityData> {


    private List<ActivityData> mContents;

    @Override
    protected BaseQuickAdapter<ActivityData, BaseViewHolder> getAdapter() {
        return new ShowAdapter(R.layout.rv_card_item);
    }

    @Override
    protected void getData() {
        mContents = new ArrayList<>();
        mContents.add(new ActivityData("启舰自定义view学习01", "启舰自定义view学习01", QiViewFirstActivity.class));
        mAdapter.setNewData(mContents);
    }

    @Override
    protected String getToolbarTitle() {
        return "启舰自定义view学习";
    }

    @Override
    protected View getDialogView(String des) {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_text_item, null, false);
        TextView textView = (TextView) view.findViewById(R.id.tv_dialog);
        textView.setText(des);
        return view;
    }
}
