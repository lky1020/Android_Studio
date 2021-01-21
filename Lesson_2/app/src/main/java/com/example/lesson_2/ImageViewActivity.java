package com.example.lesson_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView iv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        //Use Glide to put online image (Required INTERNET permission from the AndroidManifest.xml)
        //Lazy to solve(possible is the src error)
        iv4 = findViewById(R.id.iv_4);
        Glide.with(this).load("//www.baidu.com/img/bd_logo1.png").into(iv4);
    }
}
