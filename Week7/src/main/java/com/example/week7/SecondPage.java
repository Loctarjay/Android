package com.example.week7;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondPage extends AppCompatActivity implements View.OnClickListener {

    private TextView getText;
    private Button frontPage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        Intent text = getIntent();
        String showText = text.getExtras().getString(MainActivity.msg);

        getText = findViewById(R.id.YourText);
        getText.setText(showText);


        frontPage = findViewById(R.id.FrontPage);
        frontPage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.FrontPage:
                finish();
                break;
        }

    }
}
