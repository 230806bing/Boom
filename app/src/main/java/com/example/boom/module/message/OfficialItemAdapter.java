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
 * Date：2022/6/4 22:14
 */
public class OfficialItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<OfficialItem> officialItems = new ArrayList<>();

    public OfficialItemAdapter(List<OfficialItem> officialItems) {
        this.officialItems = officialItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.official_item,parent,false);
        return new OfficialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        OfficialItem officialItem = officialItems.get(position);
        ((OfficialViewHolder) holder).ivTheme.setImageResource(officialItem.getImageRes());
        ((OfficialViewHolder) holder).tvTitle.setText(officialItem.getTitle());
        ((OfficialViewHolder) holder).tvContent.setText(officialItem.getContent());
        ((OfficialViewHolder) holder).tvTime.setText(officialItem.getTime());
    }

    @Override
    public int getItemCount() {
        return officialItems.size();
    }

    static class OfficialViewHolder extends RecyclerView.ViewHolder{
        ImageView ivTheme;
        TextView tvTitle;
        TextView tvContent;
        TextView tvTime;

        public OfficialViewHolder(@NonNull View itemView) {
            super(itemView);
            ivTheme = itemView.findViewById(R.id.iv_theme);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvTime = itemView.findViewById(R.id.tv_time);
        }
    }
}
