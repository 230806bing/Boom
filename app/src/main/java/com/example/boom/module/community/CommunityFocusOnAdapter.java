package com.example.boom.module.community;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boom.R;
import com.example.boom.databinding.CommunityFocusOnItemBinding;
import com.example.boom.module.community.view.MultiImageView;
import com.example.boom.module.message.MessageItemAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module.community
 * Author：陈冰
 * Date：2022/6/5 14:59
 */
public class CommunityFocusOnAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<CommunityFocusOnItem> communityFocusOnItems = new ArrayList<>();
    Context context = null;
    Bitmap bitmap;


    public CommunityFocusOnAdapter() {
    }

    public CommunityFocusOnAdapter(List<CommunityFocusOnItem> communityFocusOnItems, Context context) {
        this.communityFocusOnItems = communityFocusOnItems;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CommunityFocusOnItemBinding communityFocusOnItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.community_focus_on_item,parent,false);
        return new CommunityFocusOnViewHolder(communityFocusOnItemBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CommunityFocusOnItem communityFocusOnItem = communityFocusOnItems.get(position);
        CommunityFocusOnItemBinding communityFocusOnItemBinding = DataBindingUtil.getBinding(holder.itemView);

        communityFocusOnItemBinding.ivPortrait.setImageResource(communityFocusOnItem.getImageRes());
        communityFocusOnItemBinding.tvUsername.setText(communityFocusOnItem.getUsername());
        communityFocusOnItemBinding.tvContent.setText(communityFocusOnItem.getContent());
        communityFocusOnItemBinding.tvTime.setText(communityFocusOnItem.getTime());
        communityFocusOnItemBinding.tvTopic.setText(communityFocusOnItem.getTopic());
        communityFocusOnItemBinding.tvShare.setText(communityFocusOnItem.getShared());
        communityFocusOnItemBinding.tvComment.setText(communityFocusOnItem.getComment());
        communityFocusOnItemBinding.tvLike.setText(communityFocusOnItem.getLiked());
        if (communityFocusOnItem.isFocusOn()){
            communityFocusOnItemBinding.btnFocusOn.setText("已关注");
            communityFocusOnItemBinding.btnFocusOn.setTextColor(0xBFA3A2A2);
        }else {
            communityFocusOnItemBinding.btnFocusOn.setText(R.string.focus_on_add);
        }
        communityFocusOnItemBinding.multiImage.setList(communityFocusOnItem.getImageList());
        Log.e("TAG", communityFocusOnItem.getImageList().size()+"");
        Log.e("TAG", communityFocusOnItem.getImageList().get(0));
        Log.e("TAG", communityFocusOnItem.getImageList().get(1));
//        communityFocusOnItemBinding.multiImageView.setOnItemClickListener(new MultiImageView.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int a) {
//                bitmap = returnBitMap(communityFocusOnItem.getImageList().get(a));
//                bigImageLoader(bitmap);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return communityFocusOnItems.size();
    }

    private void bigImageLoader(Bitmap bitmap){
        final Dialog dialog = new Dialog(context);
        ImageView image = new ImageView(context);
        image.setImageBitmap(bitmap);
        dialog.setContentView(image);
        //将dialog周围的白块设置为透明
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        //显示
        dialog.show();
        //点击图片取消
        image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialog.cancel();
            }
        });
    }

    public Bitmap returnBitMap(final String url){

        new Thread(new Runnable() {
            @Override
            public void run() {
                URL imageurl = null;

                try {
                    imageurl = new URL(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    HttpURLConnection conn = (HttpURLConnection)imageurl.openConnection();
                    conn.setDoInput(true);
                    conn.connect();
                    InputStream is = conn.getInputStream();
                    bitmap = BitmapFactory.decodeStream(is);
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return bitmap;
    }

    static class CommunityFocusOnViewHolder extends RecyclerView.ViewHolder {
        public CommunityFocusOnViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
