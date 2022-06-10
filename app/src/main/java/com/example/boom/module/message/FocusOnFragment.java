package com.example.boom.module.message;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.boom.R;
import com.example.boom.base.fragment.BaseFragment;
import com.example.boom.databinding.FragmentFocusOnBinding;

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
public class FocusOnFragment extends BaseFragment<FocusOnViewModel, FragmentFocusOnBinding> {
    List<MessageItem> messageItems = new ArrayList<>();

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_focus_on;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initData();
        initView();
    }

    private void initView() {
        mBinding.rvChatList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBinding.rvChatList.setAdapter(new MessageItemAdapter(messageItems));
        mBinding.rvChatList.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }

    private void initData() {
        MessageItem messageItem1 = new MessageItem(R.drawable.portrait1,"一芳","吃饭了吗？","20:30");
        MessageItem messageItem2 = new MessageItem(R.drawable.portrait2,"一颗冰","你到哪啦？","18:30");
        messageItems.add(messageItem1);
        messageItems.add(messageItem2);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
