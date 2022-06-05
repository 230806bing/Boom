package com.example.boom.module.homepage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boom.R;
import com.example.boom.databinding.ShowItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.homepage
 * Author：陈冰
 * Date：2022/6/6 0:23
 */
public class MusicShowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<MusicShowItem> musicShowItems;

    public MusicShowAdapter(List<MusicShowItem> musicShowItems) {
        this.musicShowItems = musicShowItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ShowItemBinding showItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.show_item,
                parent,false);
        return new MusicShowViewHolder(showItemBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MusicShowItem musicShowItem = musicShowItems.get(position);
        ShowItemBinding showItemBinding = DataBindingUtil.getBinding(holder.itemView);
        showItemBinding.ivShowCover.setImageResource(musicShowItem.getImageRes());
        showItemBinding.tvTitle.setText(musicShowItem.getTitle());
        showItemBinding.tvLocation.setText(musicShowItem.getLocation());
        showItemBinding.tvAddress.setText(musicShowItem.getAddress());
        showItemBinding.tvTime.setText(musicShowItem.getTime());
        showItemBinding.tvTag.setText(musicShowItem.getTag());
        showItemBinding.tvPrice.setText(musicShowItem.getPrice());




    }

    @Override
    public int getItemCount() {
        return musicShowItems.size();
    }

    static class MusicShowViewHolder extends RecyclerView.ViewHolder{

        public MusicShowViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
