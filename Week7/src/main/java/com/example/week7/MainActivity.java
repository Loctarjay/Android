package com.example.week7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button submit;
    private EditText input;
    public static final String msg = "input";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.Input);

        submit = findViewById(R.id.Submit);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Submit:
                Intent textInput = new Intent(this, SecondPage.class);
                textInput.putExtra(msg, input.getText().toString());
                startActivity(textInput);
        }

    }
}
