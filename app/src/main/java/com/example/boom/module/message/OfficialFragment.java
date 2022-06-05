package com.example.boom.module.message;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.boom.R;
import com.example.boom.base.fragment.BaseFragment;
import com.example.boom.databinding.FragmentOfficialBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.message
 * Author：陈冰
 * Date：2022/6/4 18:18
 */
public class OfficialFragment extends BaseFragment<OfficialViewModel, FragmentOfficialBinding> {
    List<OfficialItem> officialItems = new ArrayList<>();
    @Override
    protected int getContentViewId() {
        return R.layout.fragment_official;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initData();
        initView();
    }

    private void initView() {
        mBinding.rvOfficial.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBinding.rvOfficial.setAdapter(new OfficialItemAdapter(officialItems));
    }

    private void initData() {
        OfficialItem officialItem1 = new OfficialItem(R.drawable.mine_background,"[春日和]生活方式/海底时光机/春日玫瑰联合巡演 广州站 加场",
                "#独立,电子,流行 04.30. 周六 20:00 广州\\n[春日和] 加长官宣！生活方式/海底时光机/春日玫瑰 联合巡演\\n春日，留一个和风细雨的夜晚给现场的歌声，和我们在全新的日子里相见。",
                "04-26 19:53");
        OfficialItem officialItem2 = new OfficialItem(R.drawable.background,"[春日和]生活方式/海底时光机/春日玫瑰联合巡演 广州站 加场",
                "#独立,电子,流行 04.30. 周六 20:00 广州\\n[春日和] 加长官宣！生活方式/海底时光机/春日玫瑰 联合巡演\\n春日，留一个和风细雨的夜晚给现场的歌声，和我们在全新的日子里相见。",
                "04-26 19:53");
        officialItems.add(officialItem1);
        officialItems.add(officialItem2);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
