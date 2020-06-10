package com.madapas.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder>{

    private ArrayList<Name> names;
    private OnItemClickListener listener;
    public NameAdapter(ArrayList<Name> names ,OnItemClickListener listener) {
        this.names = names;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_name_layout,null,false);
        return new NameViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
            Name name = names.get(position);
            holder.bind(name);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    class NameViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        Name name;
        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.custom_tv_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(name);
                }
            });
        }
        void bind(Name name){
            this.name=name;
            tv_name.setText(name.getName());
        }

    }
    interface OnItemClickListener {
        void onItemClick(Name name);
    }
}
