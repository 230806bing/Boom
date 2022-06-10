package com.example.boom.module.community;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.example.boom.R;
import com.example.boom.base.activity.BaseActivity;
import com.example.boom.databinding.ActivityPostingBinding;
import com.example.boom.module.homepage.HomePageActivity;

public class PostingActivity extends BaseActivity<PostingViewModel, ActivityPostingBinding> {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_posting;
    }

    @Override
    protected void processLogic() {
    }

    @Override
    protected void setListener() {
        mBinding.tvCancel.setOnClickListener(this);
        mBinding.btnSend.setOnClickListener(this);
        mBinding.ivCameraBackground.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_cancel:
                finish();
                break;
            case R.id.btn_send:
                ToastUtils.showShort("功能待实现！");
                break;
            case R.id.iv_camera_background:
                ToastUtils.showShort("待上线");
                break;
            default:
                break;
        }
    }
}