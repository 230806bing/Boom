package com.example.boom.module.homepage;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.boom.R;
import com.example.boom.base.fragment.BaseFragment;
import com.example.boom.databinding.FragmentHomepageShowBinding;
import com.example.boom.module.BlankFragment;
import com.example.boom.module.message.MyFragmentPagerAdapter;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnPageChangeListener;
import com.youth.banner.transformer.AlphaPageTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.homepage
 * Author：陈冰
 * Date：2022/6/5 17:50
 */
public class HomePageShowFragment extends BaseFragment<HomePageShowViewModel, FragmentHomepageShowBinding> {
    List<Integer> imageResList = new ArrayList<>();
    List<Fragment> mHomePageShowFragments;
    private String[] mTitleArrays = {"音乐演出", "话剧歌剧","相声","现代曲艺","脱口秀"};
    @Override
    protected int getContentViewId() {
        return R.layout.fragment_homepage_show;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initData();
        initBanner(imageResList);
        initView();
    }

    private void initView() {
        mHomePageShowFragments = new ArrayList<>();
        mHomePageShowFragments.add(new HomePageMusicShowFragment());
        mHomePageShowFragments.add(new BlankFragment(getString(R.string.drama_opera)));
        mHomePageShowFragments.add(new BlankFragment(getString(R.string.crosstalk)));
        mHomePageShowFragments.add(new BlankFragment(getString(R.string.modern_vocal)));
        mHomePageShowFragments.add(new BlankFragment(getString(R.string.talk_show)));

        MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), mHomePageShowFragments);
        mBinding.vpHomepageShow.setAdapter(pagerAdapter);

        mBinding.tlHomepageShowTab.setViewPager(mBinding.vpHomepageShow, mTitleArrays);//tab和ViewPager进行关联
    }

    private void initData() {
        imageResList.add(R.drawable.background);
        imageResList.add(R.drawable.mine_background);
        imageResList.add(R.drawable.background);

    }

    private void initBanner(List<Integer> imageResList) {
        mBinding.showBanner.setAdapter(new BannerImageAdapter(imageResList))
                .isAutoLoop(false)
                .setIndicator(new CircleIndicator(getContext()))
                .addPageTransformer(new AlphaPageTransformer());
        mBinding.showBanner.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
