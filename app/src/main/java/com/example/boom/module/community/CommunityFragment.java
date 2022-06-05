package com.example.boom.module.community;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.example.boom.R;
import com.example.boom.base.fragment.BaseFragment;
import com.example.boom.databinding.FragmentCommunityBinding;
import com.example.boom.module.message.MyFragmentPagerAdapter;
import com.example.boom.module.message.OfficialFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.community
 * Author：陈冰
 * Date：2022/6/4 14:10
 */
public class CommunityFragment extends BaseFragment<CommunityFragmentViewModel, FragmentCommunityBinding> {
    List<Fragment> mCommunityFragments;
    private String[] mTitleArrays = {"关注", "推荐", "最新"};

    @Override

    protected int getContentViewId() {
        return R.layout.fragment_community;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        mCommunityFragments = new ArrayList<>();
        mCommunityFragments.add(new CommunityFocusOnFragment());
        mCommunityFragments.add(new CommunityRecommendFragment());
        mCommunityFragments.add(new CommunityLatestFragment());

        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), mCommunityFragments);
        mBinding.vpCommunity.setAdapter(pagerAdapter);

        mBinding.tlCommunityTab.setViewPager(mBinding.vpCommunity, mTitleArrays);//tab和ViewPager进行关联
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
