package com.example.boom.module.mine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.boom.R;
import com.example.boom.base.activity.BaseActivity;
import com.example.boom.databinding.ActivityFocusOnBinding;
import com.example.boom.module.message.MessageItem;
import com.example.boom.module.message.MessageItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class FocusOnActivity extends BaseActivity<ActivityFocusOnViewModel, ActivityFocusOnBinding> {
    List<FocusOnItem> focusOnItems = new ArrayList<>();


    @Override
    protected int getContentViewId() {
        return R.layout.activity_focus_on;
    }

    @Override
    protected void processLogic() {
        initData();
        initView();
    }

    private void initData() {
        FocusOnItem focusOnItem1 = new FocusOnItem(R.drawable.portrait2,"月光","流行");
        FocusOnItem focusOnItem2 = new FocusOnItem(R.drawable.portrait4,"星辰","世界音乐");
        focusOnItems.add(focusOnItem1);
        focusOnItems.add(focusOnItem2);
    }

    private void initView() {
        mBinding.rvFocusOnList.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvFocusOnList.setAdapter(new FocusOnItemAdapter(focusOnItems));
        mBinding.rvFocusOnList.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

    }

    @Override
    protected void setListener() {
        mBinding.ivBack.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        finish();
    }
}