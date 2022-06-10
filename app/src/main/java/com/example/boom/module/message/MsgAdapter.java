package com.example.boom.module.message;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boom.R;
import com.example.boom.databinding.ChatDetailItemBinding;

import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.message
 * Author：陈冰
 * Date：2022/6/7 11:22
 */
public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.MsgViewHolder>{
    private List<MsgItem> msgItems;

    public MsgAdapter(List<MsgItem> msgItems) {
        this.msgItems = msgItems;
    }

    @NonNull
    @Override
    public MsgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ChatDetailItemBinding chatDetailItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.chat_detail_item,parent,false);
        return new MsgViewHolder(chatDetailItemBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MsgViewHolder holder, int position) {
        MsgItem msgItem = msgItems.get(position);
        ChatDetailItemBinding chatDetailItemBinding = DataBindingUtil.getBinding(holder.itemView);
        if (msgItem.getType() == MsgItem.TYPE_SEND){
            chatDetailItemBinding.ivPortraitRight.setImageResource(msgItem.getImageRes());
            chatDetailItemBinding.rightMsg.setText(msgItem.getContent());
            chatDetailItemBinding.leftLayout.setVisibility(View.GONE);
            chatDetailItemBinding.ivPortraitLeft.setVisibility(View.GONE);
        }
        else if(msgItem.getType() == MsgItem.TYPE_RECEIVED){
            chatDetailItemBinding.ivPortraitLeft.setImageResource(msgItem.getImageRes());
            chatDetailItemBinding.leftMsg.setText(msgItem.getContent());
            chatDetailItemBinding.rightLayout.setVisibility(View.GONE);
            chatDetailItemBinding.ivPortraitRight.setVisibility(View.GONE);

        }
    }

    @Override
    public int getItemCount() {
        return msgItems.size();
    }

    static class MsgViewHolder extends RecyclerView.ViewHolder{

        public MsgViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
