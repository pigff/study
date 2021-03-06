package com.example.lin.myandroidapplication.ui.hongyang;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.adapter.ShowAdapter;
import com.example.lin.myandroidapplication.base.BaseRecyclerActivity;
import com.example.lin.myandroidapplication.data.ActivityData;
import com.example.lin.myandroidapplication.ui.ContainerActivity;

import java.util.ArrayList;
import java.util.List;

public class YangViewListActivity extends BaseRecyclerActivity<ActivityData> {

    private List<ActivityData> mContents;
    @Override
    protected BaseQuickAdapter<ActivityData, BaseViewHolder> getAdapter() {
        return new ShowAdapter(R.layout.rv_card_item);
    }

    @Override
    protected void getData() {
        mContents = new ArrayList<>();
        mContents.add(new ActivityData("鸿洋自定义view学习01", "鸿洋自定义view学习01", ContainerActivity.class, ContainerActivity.YANG_ONE));
        mContents.add(new ActivityData("鸿洋自定义view学习02", "鸿洋自定义view学习02", ContainerActivity.class, ContainerActivity.YANG_SECOND));
        mContents.add(new ActivityData("鸿洋自定义view学习03", "鸿洋自定义view学习03", YangViewThirdActivity.class));
        mContents.add(new ActivityData("鸿洋自定义view学习04", "鸿洋自定义view学习04", ContainerActivity.class, ContainerActivity.YANG_FOUR));
        mContents.add(new ActivityData("鸿洋自定义view学习05", "鸿洋自定义view学习05", ContainerActivity.class, ContainerActivity.YANG_FIFTH));
        mContents.add(new ActivityData("xxxxx", "xxxx", ContainerActivity.class, ContainerActivity.GCS_ONE));
        mAdapter.setNewData(mContents);
    }

    @Override
    protected String getToolbarTitle() {
        return "鸿洋自定义view学习";
    }

    @Override
    protected View getDialogView(String des) {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_text_item, null, false);
        TextView textView = (TextView) view.findViewById(R.id.tv_dialog);
        textView.setText(des);
        return view;
    }
}
