package com.example.boom.module.homepage;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.boom.R;
import com.example.boom.base.fragment.BaseFragment;
import com.example.boom.databinding.FragmentHomepageMusicShowBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.homepage
 * Author：陈冰
 * Date：2022/6/5 23:23
 */
public class HomePageMusicShowFragment extends BaseFragment<HomePageMusicShowViewModel, FragmentHomepageMusicShowBinding> {
    List<MusicShowItem> musicShowItems = new ArrayList<>();
    @Override
    protected int getContentViewId() {
        return R.layout.fragment_homepage_music_show;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initData();
        initView();
    }

    private void initData() {
        MusicShowItem musicShowItem1 = new MusicShowItem(R.drawable.show_cover1,"首届”声音共和诗歌市集“海朋森X发光曲线X野外合作社",
                "广州","声音共和Livehouse","开演时间待定","#摇滚 独立","￥80起");
        MusicShowItem musicShowItem2 = new MusicShowItem(R.drawable.show_cover2,"5月19日 棱镜 [石头想要有糖的温度] 2022巡演 广州站",
                "广州","声音共和Livehouse","2022.05.19 周四 20:00","#华语流行 流行","￥160-260");
        musicShowItems.add(musicShowItem1);
        musicShowItems.add(musicShowItem2);
        musicShowItems.add(musicShowItem1);
        musicShowItems.add(musicShowItem2);
    }

    private void initView() {
        mBinding.rvShowList.setAdapter(new MusicShowAdapter(musicShowItems));
        mBinding.rvShowList.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.rvShowList.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.HORIZONTAL));

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
