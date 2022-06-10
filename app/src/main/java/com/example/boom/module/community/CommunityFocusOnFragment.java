package com.example.boom.module.community;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.boom.R;
import com.example.boom.base.fragment.BaseFragment;
import com.example.boom.databinding.FragmentCommunityFocusOnBinding;
import com.example.boom.module.message.MessageItem;
import com.example.boom.module.message.MessageItemAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.community
 * Author：陈冰
 * Date：2022/6/5 14:09
 */
public class CommunityFocusOnFragment extends BaseFragment<CommunityFocusOnViewModel, FragmentCommunityFocusOnBinding> {
    List<CommunityFocusOnItem> communityFocusOnItems = new ArrayList<>();
    List<String> imagesList1 = new ArrayList<>();
    List<String> imagesList2 = new ArrayList<>();
    @Override
    protected int getContentViewId() {
        return R.layout.fragment_community_focus_on;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initImageData();
        initData();
        initView();
    }

    private void initImageData() {
    }

    private void initView() {
        mBinding.rvFocusOnList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBinding.rvFocusOnList.setAdapter(new CommunityFocusOnAdapter(communityFocusOnItems,getContext()));
        mBinding.rvFocusOnList.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }

    private void initData() {
        imagesList1.add("https://img-blog.csdnimg.cn/10f12e5dffda48f688256175d5f485ad.png");
        imagesList1.add("https://img-blog.csdnimg.cn/89f1fd52c15a4231a922c8c77964aed6.png");
        imagesList1.add("https://img-blog.csdnimg.cn/10f12e5dffda48f688256175d5f485ad.png");
        imagesList1.add("https://img-blog.csdnimg.cn/89f1fd52c15a4231a922c8c77964aed6.png");
        imagesList1.add("https://img-blog.csdnimg.cn/10f12e5dffda48f688256175d5f485ad.png");
        imagesList1.add("https://img-blog.csdnimg.cn/89f1fd52c15a4231a922c8c77964aed6.png");
        imagesList2.add("https://img-blog.csdnimg.cn/0abce411203941b9b59bc21cf3a51c3f.png");
        imagesList2.add("https://img-blog.csdnimg.cn/10f12e5dffda48f688256175d5f485ad.png");
        CommunityFocusOnItem communityFocusOnItem1 = new CommunityFocusOnItem(R.drawable.portrait,"橙子味冰块","当最后一丝余晖洒尽最后的潇洒，阳光吐尽最后一口浊气。没有了所谓的地平线的影子，留下淡淡的一抹烟，淡的像被漂白过的烟飘到几米外一般。","06-01 17:52",
                "#落日","4","10","45",imagesList1,true);
        CommunityFocusOnItem communityFocusOnItem2 = new CommunityFocusOnItem(R.drawable.portrait2,"洋洋","当最后一丝余晖洒尽最后的潇洒，阳光吐尽最后一口浊气。没有了所谓的地平线的影子，留下淡淡的一抹烟，淡的像被漂白过的烟飘到几米外一般。","06-01 17:52",
                "#美景","4","100","405",imagesList2,false);
        communityFocusOnItems.add(communityFocusOnItem1);
        communityFocusOnItems.add(communityFocusOnItem2);
        communityFocusOnItems.add(communityFocusOnItem1);
    }


    @Override
    protected void setListener() {
    }

    @Override
    public void onClick(View v) {

    }
}
