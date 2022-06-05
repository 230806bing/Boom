package com.example.boom.module.message;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.boom.R;
import com.example.boom.base.fragment.BaseFragment;
import com.example.boom.databinding.FragmentMessageBinding;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.message
 * Author：陈冰
 * Date：2022/6/4 14:23
 */
public class MessageFragment extends BaseFragment<MessageViewModel, FragmentMessageBinding> {
    private List<Fragment> mMessageFragments;
    private String[] mTitleArrays = {"聊天","关注","官方"};

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_message;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        mMessageFragments = new ArrayList<>();
        mMessageFragments.add(new ChatFragment());
        mMessageFragments.add(new FocusOnFragment());
        mMessageFragments.add(new OfficialFragment());

        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), mMessageFragments);
        mBinding.vpMessage.setAdapter(pagerAdapter);

        mBinding.tlMessageTab.setViewPager(mBinding.vpMessage, mTitleArrays);//tab和ViewPager进行关联
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
