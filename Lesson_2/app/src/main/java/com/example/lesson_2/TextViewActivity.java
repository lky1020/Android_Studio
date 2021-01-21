package com.example.lesson_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {

    private TextView mTv4, mTv5, mTv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        //Strike Word
        mTv4 = findViewById(R.id.tv_4);
        mTv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //strike line
        mTv4.getPaint().setAntiAlias((true)); // 去除锯齿

        //Underline
        mTv5 = findViewById(R.id.tv_5);
        mTv5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        //Underline
        mTv6 = findViewById(R.id.tv_6);
        mTv6.setText(Html.fromHtml("<u>I'm kah Yee</u>"));
    }
}
