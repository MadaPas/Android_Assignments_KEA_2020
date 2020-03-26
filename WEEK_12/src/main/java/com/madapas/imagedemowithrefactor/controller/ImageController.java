package com.madapas.imagedemowithrefactor.controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;

import androidx.annotation.Nullable;


import com.madapas.imagedemowithrefactor.MainActivity;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ImageController {

    private MainActivity mainActivity;

    public ImageController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void handleImageReturn(int requestCode, @Nullable Intent intent) {
        if(requestCode == 0){ // it is the photoroll
            // 2. get the url for the image
            Uri uri = intent.getData(); //data from photoroll
            try {
                // 3. Create an inputstream to read the file
                InputStream is = mainActivity.getContentResolver().openInputStream(uri);  // the other is ContentProvider //handles the content of all apps in the device if it gets the uri
                // 4. Make Bitmap from stream
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                // 5. Set bitmap to imageView
                mainActivity.imageView.setImageBitmap(bitmap); //show the photo in the imageview
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if(requestCode == 1){ // it's the data from the camera
            Bitmap bitmap = (Bitmap) intent.getExtras().get("data");  // here, the data itself was provided
            // with the intent
            // 2. assign bitmap to imageView
            mainActivity.imageView.setImageBitmap(bitmap);
            //resize the image
            mainActivity.imageView.animate().scaleX(0.4f).scaleY(0.4f);
            //get the image
            mainActivity.imageView.buildDrawingCache();
            Bitmap image = mainActivity.imageView.getDrawingCache();
            MediaStore.Images.Media.insertImage(mainActivity.getContentResolver(), image, "From the camera", "This is a photo from the camera.");
        }
    }
}
