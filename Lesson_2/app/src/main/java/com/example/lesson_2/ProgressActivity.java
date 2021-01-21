package com.example.lesson_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.lesson_2.util.ToastUtil;

public class ProgressActivity extends AppCompatActivity {

    private ProgressBar pb3;
    private Button btnStart, btnProgressDialog1, btnProgressDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        pb3 = findViewById(R.id.pb3);
        btnStart = findViewById(R.id.btn_start);
        btnProgressDialog1 = findViewById(R.id.btn_progress_dialog1);
        btnProgressDialog2 = findViewById(R.id.btn_progress_dialog2);

        //Set the progress
        btnStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);
            }
        });

        btnProgressDialog1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);

                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在加载...");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtil.showMsg(ProgressActivity.this, "Cancel...");
                    }
                });
                progressDialog.setCancelable(false);
                progressDialog.show();
            }
        });

        btnProgressDialog2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);

                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在加载...");
                progressDialog.show();
            }
        });
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            if(pb3.getProgress() < 100){
                handler.postDelayed(runnable, 500);
            }
            else{
                ToastUtil.showMsg(ProgressActivity.this, "加载完成");
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            pb3.setProgress(pb3.getProgress() + 5);
            handler.sendEmptyMessage(0);
        }
    };
}
