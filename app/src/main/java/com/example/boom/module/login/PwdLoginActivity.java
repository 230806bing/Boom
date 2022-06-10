package com.example.boom.module.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.boom.R;
import com.example.boom.base.activity.BaseActivity;
import com.example.boom.databinding.ActivityCodeLoginBinding;
import com.example.boom.databinding.ActivityPwdLoginBinding;
import com.example.boom.module.homepage.HomePageActivity;
import com.example.boom.module.register.RegisterActivity;

public class PwdLoginActivity extends BaseActivity<PwdLoginViewModel, ActivityPwdLoginBinding> {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_pwd_login;
    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected void setListener() {
        mBinding.btnLogin.setOnClickListener(this);
        mBinding.tvRegister.setOnClickListener(this);
        mBinding.tvUseCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_register:
                Intent intent1 = new Intent(this, RegisterActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_use_code:
                Intent intent2 = new Intent(this, CodeLoginActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.btn_login:
                if (mBinding.etUsername.getText().toString().equals("")) {
                    ToastUtils.showShort("手机号不能为空！");
                }else if (!RegexUtils.isMobileExact(mBinding.etUsername.getText().toString())) {
                    ToastUtils.showShort("请输入正确手机号！");
                } else if (mBinding.etPwd.getText().toString().equals("")) {
                    ToastUtils.showShort("密码不能为空！");
                }else {
                    Intent intent3 = new Intent(this, HomePageActivity.class);
                    startActivity(intent3);
                    finish();
                }
                break;
            default:
                break;
        }
    }
}