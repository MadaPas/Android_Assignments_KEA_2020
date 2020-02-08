package com.madapas.android_week_6_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void aboutActivity(View view) {
        Intent intent = new Intent(this, AboutBusinessActivity.class);
        startActivity(intent);
    }

    public void contactActivity(View view) {
        Intent intent = new Intent(this, ContactBusinessActivity.class);
        startActivity(intent);
    }



}