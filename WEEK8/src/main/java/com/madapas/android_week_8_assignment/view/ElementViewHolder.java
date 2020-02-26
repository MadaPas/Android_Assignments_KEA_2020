package com.madapas.android_week_8_assignment.view;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.madapas.android_week_8_assignment.R;

public class ElementViewHolder extends RecyclerView.ViewHolder {

    private ConstraintLayout rowLayout;
    private TextView noteTitle;
    private TextView deleteButton;

    public ElementViewHolder(@NonNull View itemView) {
        super(itemView);

        rowLayout = (ConstraintLayout) itemView;
        noteTitle = rowLayout.findViewById(R.id.noteTitle);
        deleteButton = rowLayout.findViewById(R.id.deleteButton);
    }

    public ConstraintLayout getRowLayout() {
        return rowLayout;
    }

    public TextView getNoteTitle() {
        return noteTitle;
    }

    public TextView getDeleteButton() {
        return deleteButton;
    }
}
