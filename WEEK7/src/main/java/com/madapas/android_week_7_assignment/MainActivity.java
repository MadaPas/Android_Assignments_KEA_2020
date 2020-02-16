package com.madapas.android_week_7_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText text;
    String savedText;
    public static final String messageKey = "MESSAGE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        text = findViewById(R.id.editText);
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveMethod(text);
            }
        });

        Button viewButton = findViewById(R.id.viewButton);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSavedActivity();
            }
        });
    }

    public void openSavedActivity() {
        Intent intent = new Intent(this, SavedActivity.class);
        intent.putExtra(messageKey, savedText);
        startActivity(intent);
    }
    public void saveMethod(View view){
        savedText = text.getText().toString();
    }

}