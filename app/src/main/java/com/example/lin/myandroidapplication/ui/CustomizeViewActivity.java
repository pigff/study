package com.example.lin.myandroidapplication.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.adapter.ShowAdapter;
import com.example.lin.myandroidapplication.base.BaseRecyclerActivity;
import com.example.lin.myandroidapplication.data.ActivityData;
import com.example.lin.myandroidapplication.ui.aige.AigeViewListActivity;
import com.example.lin.myandroidapplication.ui.hongyang.YangViewListActivity;
import com.example.lin.myandroidapplication.ui.qijian.QiJianViewListActivity;

import java.util.ArrayList;
import java.util.List;

public class CustomizeViewActivity extends BaseRecyclerActivity<ActivityData> {

    private List<ActivityData> mContents;

    @Override
    protected BaseQuickAdapter<ActivityData, BaseViewHolder> getAdapter() {
        return new ShowAdapter(R.layout.rv_card_item);
    }

    @Override
    protected void getData() {
        mContents = new ArrayList<>();
        mContents.add(new ActivityData("爱哥的自定义", "爱哥自定义文章学习", AigeViewListActivity.class));
        mContents.add(new ActivityData("鸿洋的自定义", "鸿洋自定义文章学习", YangViewListActivity.class));
        mContents.add(new ActivityData("启舰的自定义", "启舰自定义文章学习", QiJianViewListActivity.class));
        mAdapter.setNewData(mContents);
    }

    @Override
    protected String getToolbarTitle() {
        return "自定义View学习系列";
    }

    @Override
    protected View getDialogView(String des) {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_text_item, null, false);
        TextView textView = (TextView) view.findViewById(R.id.tv_dialog);
        textView.setText(des);
        return view;
    }


}
