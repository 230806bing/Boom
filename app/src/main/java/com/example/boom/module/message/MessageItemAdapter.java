package com.example.boom.module.message;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boom.R;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,parent,false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessageItem messageItem = messageItems.get(position);
        ((MessageViewHolder) holder).ivPortrait.setImageResource(messageItem.getImageRes());
        ((MessageViewHolder) holder).tvUsername.setText(messageItem.getUsername());
        ((MessageViewHolder) holder).tvContent.setText(messageItem.getContent());
        ((MessageViewHolder) holder).tvTime.setText(messageItem.getTime());
    }

    @Override
    public int getItemCount() {
        return messageItems.size();
    }

    static class MessageViewHolder extends RecyclerView.ViewHolder{
        ImageView ivPortrait;
        TextView tvUsername;
        TextView tvContent;
        TextView tvTime;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPortrait = itemView.findViewById(R.id.iv_portrait);
            tvUsername = itemView.findViewById(R.id.tv_username);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvTime = itemView.findViewById(R.id.tv_time);
        }
    }


}
