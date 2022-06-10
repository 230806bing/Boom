package com.example.boom.module.setting;


import android.content.Intent;
import android.view.View;

import com.example.boom.R;
import com.example.boom.base.activity.BaseActivity;
import com.example.boom.databinding.ActivitySettingBinding;


public class SettingActivity extends BaseActivity<SettingViewModel, ActivitySettingBinding> {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void processLogic() {

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