package com.example.lesson_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.lesson_2.util.ToastUtil;
import com.example.lesson_2.widget.MyButton;

public class EventActivity extends AppCompatActivity /*implements View.OnClickListener*/{

    private Button btnEvent, btnHandler;
    private MyButton btnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        btnEvent = findViewById(R.id.btn_event);
        btnMy = findViewById(R.id.btn_my);
        btnHandler = findViewById(R.id.btn_handler);

        btnMy.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener", "--- onTouchEvent ---");
                        break;
                }
                return false;
            }
        });
        btnMy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Listener", "--- onClick ---");
            }
        });

        //内部类实现
        btnEvent.setOnClickListener(new OnClick());

        //匿名内部类
        /*btnEvent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(EventActivity.this, "Click Me...");
            }
        });*/

        //通过事件源所在的类实现 （implements the View.OnClickListener)
        //btnEvent.setOnClickListener(EventActivity.this);

        //通过外部类实现 （create new class to achieve it) ==> class: MyClickListener
        //btnEvent.setOnClickListener(new MyClickListener(EventActivity.this));

        btnHandler.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });
    }

    //通过事件源所在的类实现 （implements the View.OnClickListener)
    /*public void onClick(View v){
        switch(v.getId()){
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this, "Click Me...");
                break;
        }
    }*/

    //内部类实现
    public class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn_event:
                    ToastUtil.showMsg(EventActivity.this, "Click Me...");
                    break;
            }
        }
    }

    //Write onClick (android:onClick="showToast") in the layout for the activity, declare the function in here
    /*public void showToast(View v){
        switch(v.getId()){
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this, "Click Me...");
                break;
        }
    }*/

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("Activity", "--- onTouchEvent ---");
                break;
        }

        return false;
    }*/

}
