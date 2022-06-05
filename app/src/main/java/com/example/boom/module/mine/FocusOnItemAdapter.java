package com.example.boom.module.mine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boom.R;
import com.example.boom.databinding.FocusOnItemBinding;
import com.example.boom.module.message.MessageItem;
import com.example.boom.module.message.MessageItemAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.mine
 * Author：陈冰
 * Date：2022/6/5 11:14
 */
public class FocusOnItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<FocusOnItem> focusOnItems = new ArrayList<>();

    public FocusOnItemAdapter(List<FocusOnItem> focusOnListItems) {
        this.focusOnItems = focusOnListItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FocusOnItemBinding focusOnItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.focus_on_item,parent,false);
        return new FocusOnViewHolder(focusOnItemBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FocusOnItem focusOnItem = focusOnItems.get(position);
        FocusOnItemBinding focusOnItemBinding = DataBindingUtil.getBinding(holder.itemView);
        focusOnItemBinding.ivPortrait.setImageResource(focusOnItem.getImageRes());
        focusOnItemBinding.tvUsername.setText(focusOnItem.getUsername());
        focusOnItemBinding.tvLike.setText(focusOnItem.getLikedStyle());
    }

    @Override
    public int getItemCount() {
        return focusOnItems.size();
    }

    static class FocusOnViewHolder extends RecyclerView.ViewHolder{

        public FocusOnViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
