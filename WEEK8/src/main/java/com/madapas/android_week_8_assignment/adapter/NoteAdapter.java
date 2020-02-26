package com.madapas.android_week_8_assignment.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.madapas.android_week_8_assignment.EditActivity;
import com.madapas.android_week_8_assignment.R;
import com.madapas.android_week_8_assignment.model.Note;
import com.madapas.android_week_8_assignment.model.NoteDatabase;
import com.madapas.android_week_8_assignment.view.ElementViewHolder;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<ElementViewHolder> {
    private List<Note> notes;

    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public ElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ElementViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_element, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ElementViewHolder holder, final int position) {
        final TextView deleteButton = holder.getDeleteButton();
        holder.getNoteTitle().setText(notes.get(position).getTitle());
        deleteButton.setTag(notes.get(position).getId().toString());
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoteDatabase.getDb(v.getContext()).noteDao().delete(notes.get(position));
                notes.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.getRowLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EditActivity.class);
                intent.putExtra(EditActivity.NOTE_KEY, notes.get(position));
                v.getContext().startActivity(intent);
            }
        });
        holder.getRowLayout().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (deleteButton.getVisibility() == View.GONE) {
                    deleteButton.setVisibility(View.VISIBLE);
                } else {
                    deleteButton.setVisibility(View.GONE);
                }
                return true;
            }
        });
    }



    @Override
    public int getItemCount() {
        return notes.size();
    }
}
