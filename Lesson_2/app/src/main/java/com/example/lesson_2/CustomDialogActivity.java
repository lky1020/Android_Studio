
package com.example.lesson_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lesson_2.util.ToastUtil;
import com.example.lesson_2.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private Button btnCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        btnCustomDialog = findViewById(R.id.btn_custom_Dialog);
        btnCustomDialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this);
                customDialog.setTitle("提示").setMessage("确定吗？").setCancel("取消", new CustomDialog.OnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog dialog) {
                        ToastUtil.showMsg(CustomDialogActivity.this, "Cancel...");
                    }
                }).setConfirm("确定", new CustomDialog.OnConfirmListener() {
                    @Override
                    public void onConfirm(CustomDialog dialog) {
                        ToastUtil.showMsg(CustomDialogActivity.this, "Confirm...");
                    }
                }).show();
            }
        });
    }
}
