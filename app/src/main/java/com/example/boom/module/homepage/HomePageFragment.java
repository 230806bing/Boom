package com.example.boom.module.homepage;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.example.boom.R;
import com.example.boom.base.fragment.BaseFragment;
import com.example.boom.databinding.FragmentHomepageBinding;
import com.example.boom.module.BlankFragment;
import com.example.boom.module.message.MyFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.homepage
 * Author：陈冰
 * Date：2022/6/4 14:26
 */
public class HomePageFragment extends BaseFragment<HomePageViewModel, FragmentHomepageBinding> {
    List<Fragment> mHomePageFragments;
    private String[] mTitleArrays = {"演出", "周边"};
    @Override
    protected int getContentViewId() {
        return R.layout.fragment_homepage;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        mHomePageFragments = new ArrayList<>();
        mHomePageFragments.add(new HomePageShowFragment());
        mHomePageFragments.add(new BlankFragment(getString(R.string.around)));

        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), mHomePageFragments);
        mBinding.vpHomepage.setAdapter(pagerAdapter);

        mBinding.tlHomepageTab.setViewPager(mBinding.vpHomepage, mTitleArrays);//tab和ViewPager进行关联

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
