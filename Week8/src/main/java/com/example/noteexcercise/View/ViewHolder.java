package com.example.noteexcercise.View;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteexcercise.R;
import com.example.noteexcercise.storage.NoteStorage;

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView textView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        LinearLayout linearLayout = (LinearLayout)itemView;
        textView = linearLayout.findViewById(R.id.textView);
    }

    public void setData(int row){
        textView.setText(NoteStorage.getNote(row).getHeadlines());
    }
}
