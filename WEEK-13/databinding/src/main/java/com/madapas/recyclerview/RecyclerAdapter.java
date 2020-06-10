package com.madapas.recyclerview;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.madapas.recyclerview.databinding.ItemLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Cat> cats = new ArrayList<>();


    // constructor
    public RecyclerAdapter(Context context, List<Cat> cats) {
        this.context = context;
        this.cats = cats;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        // object of item layout binding
        ItemLayoutBinding itemLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()), R.layout.item_layout, viewGroup, false);
        // inflate each row
        // return an object of a viewHolder class
        ViewHolder viewHolder = new ViewHolder(itemLayoutBinding);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewholder, int i) {

        // current cat object
        Cat cat = cats.get(i);

        // set user to data binding
        viewholder.itemLayoutBinding.setCat(cat);


    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // create an object of the custom layout databinding class
        ItemLayoutBinding itemLayoutBinding;

        public ViewHolder(@NonNull ItemLayoutBinding itemView) {
            super(itemView.getRoot());
            // initialize the variable
            itemLayoutBinding = itemView;
        }
    }
}
