package com.example.boom.module.message;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.boom.R;
import com.example.boom.base.fragment.BaseFragment;
import com.example.boom.databinding.FragmentChatBinding;

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
public class ChatFragment extends BaseFragment<ChatViewModel, FragmentChatBinding> {
    List<MessageItem> messageItems = new ArrayList<>();
    @Override
    protected int getContentViewId() {
        return R.layout.fragment_chat;
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
        MessageItem messageItem1 = new MessageItem(R.drawable.portrait1,"蒋蒋","星星掉地里去啦，我要去接住它！","18:30");
        MessageItem messageItem2 = new MessageItem(R.drawable.portrait2,"洋洋","迪士尼呢 不想玩嘛","20:00");
        MessageItem messageItem3 = new MessageItem(R.drawable.portrait5,"智慧蒋","我的月亮永悬天上","13:00");
        MessageItem messageItem4 = new MessageItem(R.drawable.portrait4,"月洋","我的太阳永不凋落","11:30");
        MessageItem messageItem5 = new MessageItem(R.drawable.portrait3,"蒋洋大盗","会一直一起玩游戏的！","01:08");
        messageItems.add(messageItem1);
        messageItems.add(messageItem2);
        messageItems.add(messageItem3);
        messageItems.add(messageItem4);
        messageItems.add(messageItem5);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
