package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

public class MainActivity extends AppCompatActivity {

    private ImageView adjust_image;
    private String image_url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adjust_image = findViewById(R.id.adjust_image);
        image_url = "https://www.freepngimg.com/thumb/android/31020-9-android-photos.png";

        Glide.with(MainActivity.this).asBitmap().load(image_url).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                int width = adjust_image.getMeasuredWidth();
                int diw = resource.getWidth();
                if (diw > 0) {
                    int height = 0;
                    height = width * resource.getHeight() / diw;
                    resource = Bitmap.createScaledBitmap(resource, width, height, false);
                }
                adjust_image.setImageBitmap(resource);
            }
        });
    }
}