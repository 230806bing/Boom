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
import com.example.boom.databinding.OfficialItemBinding;

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
        OfficialItemBinding officialItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.official_item,parent,false);
        return new OfficialViewHolder(officialItemBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        OfficialItem officialItem = officialItems.get(position);
        OfficialItemBinding officialItemBinding = DataBindingUtil.getBinding(holder.itemView);
        officialItemBinding.ivTheme.setImageResource(officialItem.getImageRes());
        officialItemBinding.tvTitle.setText(officialItem.getTitle());
        officialItemBinding.tvContent.setText(officialItem.getContent());
        officialItemBinding.tvTime.setText(officialItem.getTime());
    }

    @Override
    public int getItemCount() {
        return officialItems.size();
    }

    static class OfficialViewHolder extends RecyclerView.ViewHolder{

        public OfficialViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
