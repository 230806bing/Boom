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
import androidx.recyclerview.widget.RecyclerView;

import com.example.boom.R;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.community_focus_on_item,parent,false);
        return new CommunityFocusOnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CommunityFocusOnItem communityFocusOnItem = communityFocusOnItems.get(position);
        ((CommunityFocusOnViewHolder) holder).ivPortrait.setImageResource(communityFocusOnItem.getImageRes());
        ((CommunityFocusOnViewHolder) holder).tvUsername.setText(communityFocusOnItem.getUsername());
        ((CommunityFocusOnViewHolder) holder).tvContent.setText(communityFocusOnItem.getContent());
        ((CommunityFocusOnViewHolder) holder).tvTime.setText(communityFocusOnItem.getTime());
        ((CommunityFocusOnViewHolder) holder).tvTopic.setText(communityFocusOnItem.getTopic());
        ((CommunityFocusOnViewHolder) holder).tvShare.setText(communityFocusOnItem.getShared());
        ((CommunityFocusOnViewHolder) holder).tvComment.setText(communityFocusOnItem.getComment());
        ((CommunityFocusOnViewHolder) holder).tvLiked.setText(communityFocusOnItem.getLiked());
        if (communityFocusOnItem.isFocusOn()){
            ((CommunityFocusOnViewHolder) holder).btnFocusOn.setText("已关注");
            ((CommunityFocusOnViewHolder) holder).btnFocusOn.setTextColor(0xBFA3A2A2);
        }else {
            ((CommunityFocusOnViewHolder) holder).btnFocusOn.setText(R.string.focus_on_add);
        }
        ((CommunityFocusOnViewHolder) holder).multiImageView.setList(communityFocusOnItem.getImageList());
        Log.e("TAG", communityFocusOnItem.getImageList().size()+"");
        Log.e("TAG", communityFocusOnItem.getImageList().get(0));
        Log.e("TAG", communityFocusOnItem.getImageList().get(1));
//        ((CommunityFocusOnViewHolder) holder).multiImageView.setOnItemClickListener(new MultiImageView.OnItemClickListener() {
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
        ImageView ivPortrait;
        TextView tvUsername;
        TextView tvContent;
        TextView tvTime;
        TextView tvTopic;
        TextView tvShare;
        TextView tvComment;
        TextView tvLiked;
        Button btnFocusOn;
        MultiImageView multiImageView;
        public CommunityFocusOnViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPortrait = itemView.findViewById(R.id.iv_portrait);
            tvUsername = itemView.findViewById(R.id.tv_username);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvTopic = itemView.findViewById(R.id.tv_topic);
            tvShare = itemView.findViewById(R.id.tv_share);
            tvComment  = itemView.findViewById(R.id.tv_comment);
            tvLiked  = itemView.findViewById(R.id.tv_like);
            btnFocusOn  = itemView.findViewById(R.id.btn_focus_on);
            multiImageView = itemView.findViewById(R.id.multi_image);
        }
    }
}
