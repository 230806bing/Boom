package com.example.boom.module.message;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boom.R;
import com.example.boom.databinding.ChatItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.message
 * Author：陈冰
 * Date：2022/6/4 20:50
 */
public class MessageItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<MessageItem> messageItems = new ArrayList<>();

    public MessageItemAdapter(List<MessageItem> messageItems) {
        this.messageItems = messageItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ChatItemBinding chatItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.chat_item,parent,false);
        return new MessageViewHolder(chatItemBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessageItem messageItem = messageItems.get(position);
        ChatItemBinding chatItemBinding = DataBindingUtil.getBinding(holder.itemView);
        chatItemBinding.ivPortrait.setImageResource(messageItem.getImageRes());
        chatItemBinding.tvUsername.setText(messageItem.getUsername());
        chatItemBinding.tvContent.setText(messageItem.getContent());
        chatItemBinding.tvTime.setText(messageItem.getTime());
    }

    @Override
    public int getItemCount() {
        return messageItems.size();
    }

    static class MessageViewHolder extends RecyclerView.ViewHolder{

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}
