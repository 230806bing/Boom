package com.example.boom.module.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.boom.R;
import com.example.boom.base.activity.BaseActivity;
import com.example.boom.databinding.ActivityRegisterBinding;
import com.example.boom.module.login.PwdLoginActivity;

public class RegisterActivity extends BaseActivity<RegisterViewModel, ActivityRegisterBinding> {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_register;
    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected void setListener() {
        mBinding.btnRegister.setOnClickListener(this);
        mBinding.tvLogin.setOnClickListener(this);
        mBinding.tvSendCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                if (mBinding.etUsername.getText().toString().equals("")) {
                    ToastUtils.showShort("用户名不能为空！");
                } else if (!RegexUtils.isMobileExact(mBinding.etPhone.getText().toString())) {
                    ToastUtils.showShort("请输入正确手机号！");
                }else if (mBinding.etPwd.getText().toString().length() < 6 || mBinding.etPwd.getText().toString().length() > 20) {
                    ToastUtils.showShort("请输入6-20位密码！");
                } else if (!mBinding.etPwd.getText().toString().equals(mBinding.etPwdAgain.getText().toString())) {
                    ToastUtils.showShort("两次密码不一致，请重新输入！");
                }  else {
                    ToastUtils.showShort("注册成功,请返回登陆");
                    mBinding.etPhone.setText("");
                    mBinding.etUsername.setText("");
                    mBinding.etPhone.setText("");
                    mBinding.etCode.setText("");
                    mBinding.etPwd.setText("");
                    mBinding.etPwdAgain.setText("");
                }

                break;
            case R.id.tv_send_code:
                ToastUtils.showShort("功能待上线");
                break;
            case R.id.tv_login:
                Intent intent = new Intent(this, PwdLoginActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }
}