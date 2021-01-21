package com.example.lesson_2;

import android.app.Activity;
import android.view.View;

import com.example.lesson_2.util.ToastUtil;

public class MyClickListener implements View.OnClickListener {

    private Activity activity;

    public MyClickListener(Activity activity){
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        ToastUtil.showMsg(this.activity, "Click Me...");
    }
}
