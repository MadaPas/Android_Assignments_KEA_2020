package com.madapas.android_week_7_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SavedActivity extends AppCompatActivity {

    String savedText;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        Intent intent = getIntent();
        savedText = intent.getStringExtra(MainActivity.messageKey);

        result = findViewById(R.id.result);
        result.setText(savedText);
    }


}