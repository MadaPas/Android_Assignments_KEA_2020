package com.madapas.imagedemowithrefactor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.madapas.imagedemowithrefactor.controller.ImageController;


public class MainActivity extends AppCompatActivity {

    public ImageView imageView;
    private ImageController ic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        ic = new ImageController(this);
    }

    public void photoRollBtnPressed(View view){
        // 1. make an intent
        // start activity (which will make Android system launch one activity which CAN
        // handle this "request"
        Intent intent = new Intent(Intent.ACTION_PICK);  //
        intent.setType("image/*");
        startActivityForResult(intent, 0); // 0 means photoroll, 1 means camera
    }

    @Override
    //this is code for what happens when we return from the intent, e.g. the result of the intent
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        // 1. check if result is OK. If not, then return
        if(resultCode != -1) return; // -1 indicates OK (that everything went well, and if it didn't go well, we just return)
        ic.handleImageReturn(requestCode, intent);
    }



    public void cameraBtnPressed(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);  // we ask Android for something different // it gets us to the camera
        startActivityForResult(intent, 1);
    }

    private void handlePermissionUpdate() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            handlePermissionUpdate();
        }
    }
}