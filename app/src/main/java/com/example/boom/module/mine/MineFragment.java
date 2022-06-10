package com.example.boom.module.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.boom.R;
import com.example.boom.base.fragment.BaseFragment;
import com.example.boom.databinding.FragmentMineBinding;
import com.example.boom.module.setting.SettingActivity;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.mine
 * Author：陈冰
 * Date：2022/6/4 14:25
 */
public class MineFragment extends BaseFragment<MineViewModel, FragmentMineBinding> {
    @Override
    protected int getContentViewId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {
        mBinding.ivSetting.setOnClickListener(this);
        mBinding.tvFocusOnNum.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_setting:
                Intent intent1 = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_focus_on_num:
                Intent intent2 = new Intent(getActivity(),FocusOnActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }

    }
}
