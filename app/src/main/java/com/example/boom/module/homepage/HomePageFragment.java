package com.example.boom.module.homepage;

import android.os.Bundle;
import android.view.View;

import com.example.boom.R;
import com.example.boom.base.fragment.BaseFragment;
import com.example.boom.databinding.FragmentHomepageBinding;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.homepage
 * Author：陈冰
 * Date：2022/6/4 14:26
 */
public class HomePageFragment extends BaseFragment<HomePageViewModel, FragmentHomepageBinding> {
    @Override
    protected int getContentViewId() {
        return R.layout.fragment_homepage;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
