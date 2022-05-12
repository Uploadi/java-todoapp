package com.example.recyclerviewtodolist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    CheckBox checkbox;
    TextView textView;
    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        checkbox = itemView.findViewById(R.id.item_checkbox1);
        textView = itemView.findViewById(R.id.item_Subtext_Checkbox);
    }
}
