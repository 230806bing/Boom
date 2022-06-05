package com.example.boom.module;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.boom.R;

/**
 * Description：
 * Param：
 * return：
 * PackageName：com.example.boom.module
 * Author：陈冰
 * Date：2022/6/5 23:24
 */
public class BlankFragment extends Fragment {
    String hint;
    public BlankFragment(String hint) {
        this.hint = hint;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(inflater.getContext()).inflate(R.layout.fragment_blank,container,false);
        TextView textView = view.findViewById(R.id.tv_hint);
        textView.setText(hint);
        return view;
    }



}
