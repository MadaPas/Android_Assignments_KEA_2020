package com.madapas.recyclerview;

import android.content.Context;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

import de.hdodenhof.circleimageview.CircleImageView;

public class Cat {
    public String name, description;
    public int imageId;

    public Cat(String name, String description, int imageId) {
        this.name = name;
        this.description = description;
        this.imageId = imageId;
    }

    @BindingAdapter("android:imageUrl")
    public static void loadImage(View view, int imageId) {
        CircleImageView circleImageView = (CircleImageView) view;
        circleImageView.setImageDrawable(ContextCompat.getDrawable(view.getContext(), imageId));
    }
}
