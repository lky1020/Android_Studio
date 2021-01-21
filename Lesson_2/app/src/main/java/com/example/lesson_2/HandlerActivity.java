package com.example.lesson_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.lesson_2.util.ToastUtil;

public class HandlerActivity extends AppCompatActivity {

    private Handler handler;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        //handler use to control the time for the activity
        /*handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(HandlerActivity.this, ButtonActivity.class);
                startActivity(intent);
            }
        }, 3000);*/

        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch(msg.what){
                    case 1:
                        ToastUtil.showMsg(HandlerActivity.this, "线程通信成功");
                        break;
                }
            }
        };

        new Thread(){
            @Override
            public void run() {
                super.run();

                Message message = new Message();
                message.what = 1;

                handler.sendMessage(message);
            }
        }.start();
    }
}
