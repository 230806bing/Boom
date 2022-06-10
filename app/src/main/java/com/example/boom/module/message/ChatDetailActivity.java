package com.example.boom.module.message;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.example.boom.R;
import com.example.boom.base.activity.BaseActivity;
import com.example.boom.databinding.ActivityChatDetailBinding;
import com.example.boom.module.homepage.HomePageActivity;

import java.util.ArrayList;
import java.util.List;

public class ChatDetailActivity extends BaseActivity<ChatDetailViewModel, ActivityChatDetailBinding> {
    private List<MsgItem> msgItemList = new ArrayList<>();
    private MsgAdapter msgAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_chat_detail;
    }

    @Override
    protected void processLogic() {
        initView();
        initData();
    }

    private void initView() {
        msgAdapter = new MsgAdapter(msgItemList = initData());
        mBinding.rvChatDetail.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvChatDetail.setAdapter(msgAdapter);
    }

    private List<MsgItem> initData() {
        List<MsgItem> msgItems = new ArrayList<>();
        MsgItem msgItem1 = new MsgItem(R.drawable.portrait2,"你到哪啦？",MsgItem.TYPE_RECEIVED);
        msgItems.add(msgItem1);
        return msgItems;
    }

    @Override
    protected void setListener() {
        mBinding.btnSend.setOnClickListener(this);
        mBinding.ivBack.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_send:
                String content = mBinding.etInput.getText().toString();
                if (content.equals("")){
                    ToastUtils.showShort("输入内容不能为空！");
                }else{
                    msgItemList.add(new MsgItem(R.drawable.portrait,content,1));
                    msgAdapter.notifyItemInserted(msgItemList.size()-1);
                    mBinding.rvChatDetail.scrollToPosition(msgItemList.size()-1);
                    mBinding.etInput.setText("");
                }
                if(msgItemList.size() == 2){
                    msgItemList.add(new MsgItem(R.drawable.portrait2,"快点哦！",MsgItem.TYPE_RECEIVED));
                    msgAdapter.notifyItemInserted(msgItemList.size()-1);
                    mBinding.rvChatDetail.scrollToPosition(msgItemList.size()-1);
                }
                if(msgItemList.size() == 4){
                    msgItemList.add(new MsgItem(R.drawable.portrait2,"好滴",MsgItem.TYPE_RECEIVED));
                    msgAdapter.notifyItemInserted(msgItemList.size()-1);
                    mBinding.rvChatDetail.scrollToPosition(msgItemList.size()-1);
                }
                break;
            case R.id.iv_back:
                Intent intent = new Intent(this, HomePageActivity.class);
                intent.putExtra("isChatDetail",true);
                intent.putExtra("content","好滴");
                startActivity(intent);
                break;
        }

    }
}