package com.example.boom.module.login;

import android.content.Intent;
import android.view.View;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.example.boom.R;
import com.example.boom.base.activity.BaseActivity;
import com.example.boom.databinding.ActivityCodeLoginBinding;
import com.example.boom.module.register.RegisterActivity;

public class CodeLoginActivity extends BaseActivity<CodeLoginViewModel, ActivityCodeLoginBinding> {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_code_login;
    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected void setListener() {
        mBinding.tvSendCode.setOnClickListener(this);
        mBinding.tvRegister.setOnClickListener(this);
        mBinding.tvUsePwd.setOnClickListener(this);
        mBinding.btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_send_code:
                ToastUtils.showShort("功能待上线");
                break;
            case R.id.tv_register:
                Intent intent1 = new Intent(this, RegisterActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_use_pwd:
                Intent intent2 = new Intent(this, PwdLoginActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.btn_login:
                if (mBinding.etPhone.getText().toString().equals("")) {
                    ToastUtils.showShort("手机号不能为空！");
                }else if (!RegexUtils.isMobileExact(mBinding.etPhone.getText().toString())) {
                    ToastUtils.showShort("请输入正确手机号！");
                } else if (mBinding.etCode.getText().toString().equals("")) {
                    ToastUtils.showShort("验证码不能为空！");
                }else {
                    ToastUtils.showShort("验证码登录功能暂未实现！");

                }
                break;
            default:
                break;
        }

    }
}