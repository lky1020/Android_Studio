package com.example.lesson_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lesson_2.dataStorage.DataStorageActivity;

public class UiActivity extends AppCompatActivity {

    private Button btnLesson1to3;
    private Button btnLesson4;
    private Button btnLesson5;
    private Button btnLesson7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        btnLesson1to3 = findViewById(R.id.btn_lesson1to3);
        btnLesson4 = findViewById(R.id.btn_lesson4);
        btnLesson5 = findViewById(R.id.btn_lesson5);
        btnLesson7 = findViewById(R.id.btn_lesson7);
        setListeners();
    }

    private void setListeners(){
        OnClick onClick = new OnClick();
        btnLesson1to3.setOnClickListener(onClick);
        btnLesson4.setOnClickListener(onClick);
        btnLesson5.setOnClickListener(onClick);
        btnLesson7.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;

            switch(v.getId()){
                case R.id.btn_lesson1to3:
                    //Jump to MainActivity.java
                    intent = new Intent(UiActivity.this, MainActivity.class);
                    break;
                case R.id.btn_lesson4:
                    //Jump to TestActivity.java
                    intent = new Intent(UiActivity.this, TestActivity.class);
                    break;
                case R.id.btn_lesson5:
                    //Jump to EventActivity.java
                    intent = new Intent(UiActivity.this, EventActivity.class);
                    break;
                case R.id.btn_lesson7:
                    //Jump to DataStorageActivity.java
                    intent = new Intent(UiActivity.this, DataStorageActivity.class);
                    break;
            }

            startActivity(intent);
        }
    }
}
