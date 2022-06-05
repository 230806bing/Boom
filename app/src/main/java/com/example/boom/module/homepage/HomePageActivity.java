package com.example.boom.module.homepage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.MenuItem;
import android.view.View;

import com.example.boom.R;
import com.example.boom.base.activity.BaseActivity;
import com.example.boom.databinding.ActivityHomePageBinding;
import com.example.boom.module.community.CommunityFragment;
import com.example.boom.module.message.MessageFragment;
import com.example.boom.module.message.MyFragmentPagerAdapter;
import com.example.boom.module.mine.MineFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends BaseActivity<HomePageViewModel, ActivityHomePageBinding> implements
        NavigationBarView.OnItemSelectedListener{
    List<Fragment> fragmentList = new ArrayList<>();
    @Override
    protected int getContentViewId() {
        return R.layout.activity_home_page;
    }

    @Override
    protected void processLogic() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        fragmentList.add(new HomePageFragment());
        fragmentList.add(new CommunityFragment());
        fragmentList.add(new MessageFragment());
        fragmentList.add(new MineFragment());
        mBinding.viewpager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),fragmentList));
        bottomNavigationView.setOnItemSelectedListener(this);
        //设置tab文字显示
        bottomNavigationView.setLabelVisibilityMode(NavigationBarView.LABEL_VISIBILITY_LABELED);
        mBinding.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        homepageViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//                bottomNavigationView.getMenu().getItem(position).setChecked(true);
//            }
//        });
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.homepage_fragment:
                mBinding.viewpager.setCurrentItem(0,false);
                break;
            case R.id.community_fragment:
                mBinding.viewpager.setCurrentItem(1,false);
                break;
            case R.id.message_fragment:
                mBinding.viewpager.setCurrentItem(2,false);
                break;
            case R.id.mine_fragment:
                mBinding.viewpager.setCurrentItem(3,false);
                break;
            default:
                break;
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBinding.viewpager.clearOnPageChangeListeners();
//        homepageViewPager.unregisterOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//            }
//        });
    }
}