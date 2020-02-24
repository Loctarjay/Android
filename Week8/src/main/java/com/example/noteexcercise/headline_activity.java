package com.example.noteexcercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.noteexcercise.adapter.MyRecycleViewAdapter;
import com.example.noteexcercise.model.Note;
import com.example.noteexcercise.storage.NoteStorage;

public class headline_activity extends AppCompatActivity implements View.OnClickListener {

    public static final String getHeadline = "GetHeadline", getMessage = "GetMessage";
    private Button frontPage;

    private EditText headline, message;

    private Intent extras;
    private Bundle bundle;
    private Boolean editing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headline);

        frontPage = findViewById(R.id.FrontPage);
        frontPage.setOnClickListener(this);

        headline = findViewById(R.id.headline);
        message = findViewById(R.id.message);

        extras = getIntent();
        bundle = extras.getExtras();
        if (bundle != null){
            headline.setText(extras.getExtras().getString(MyRecycleViewAdapter.headline));
            message.setText(extras.getExtras().getString(MyRecycleViewAdapter.message));
            editing = true;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.FrontPage:
                if (!editing) {
                    NoteStorage.getList().add(new Note(headline.getText().toString(), message.getText().toString()));
                    NoteStorage.saveNotesToFile();
                    finish();
                } else {
                    NoteStorage.getList().set(extras.getExtras().getInt(MyRecycleViewAdapter.pos), new Note(headline.getText().toString(), message.getText().toString()));
                    NoteStorage.saveNotesToFile();
                    finish();
                }
        }
    }
}
