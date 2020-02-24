package com.example.noteexcercise.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteexcercise.R;
import com.example.noteexcercise.View.ViewHolder;
import com.example.noteexcercise.headline_activity;
import com.example.noteexcercise.model.Note;
import com.example.noteexcercise.storage.NoteStorage;

import java.util.ArrayList;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Note> list;
    public static final String headline = "GetHeadline", message = "GetMessage", pos = "GetPosition";

    public MyRecycleViewAdapter() {
        this.list = NoteStorage.getList();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout ll = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.customrow, parent, false);
        return new ViewHolder(ll);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.setData(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent change = new Intent(v.getContext(), headline_activity.class);
                change.putExtra(headline, NoteStorage.getNote(position).getHeadlines());
                change.putExtra(message, NoteStorage.getNote(position).getBody());
                change.putExtra(pos, position);
                v.getContext().startActivity(change);
            }
        });
    }

    @Override
    public int getItemCount() {
        return NoteStorage.getSize();
    }
}