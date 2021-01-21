package com.example.lesson_2.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lesson_2.R;

public class CustomDialog extends Dialog implements View.OnClickListener{

    private TextView tvTitle, tvMessage, tvCancel, tvConfirm;
    private String title, message, cancel, confirm;
    private OnCancelListener cancelListener;
    private OnConfirmListener confirmListener;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    //Setters
    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel, OnCancelListener listener) {
        this.cancel = cancel;
        this.cancelListener = listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm, OnConfirmListener listener) {
        this.confirm = confirm;
        this.confirmListener = listener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);

        //set width
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int) (size.x * 0.8); // 80% of the screen width
        getWindow().setAttributes(p);

        tvTitle = findViewById(R.id.tv_title);
        tvMessage = findViewById(R.id.tv_message);
        tvCancel = findViewById(R.id.tv_cancel);
        tvConfirm = findViewById(R.id.tv_confirm);

        if(!TextUtils.isEmpty(title)){
            tvTitle.setText(title);
        }

        if(!TextUtils.isEmpty(message)){
            tvTitle.setText(message);
        }

        if(!TextUtils.isEmpty(cancel)){
            tvTitle.setText(cancel);
        }

        if(!TextUtils.isEmpty(confirm)){
            tvTitle.setText(confirm);
        }

        tvCancel.setOnClickListener(this);
        tvConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.tv_cancel:
                if (cancelListener != null){
                    cancelListener.onCancel((this));
                }
                break;
            case R.id.tv_confirm:
                if (confirmListener != null){
                    confirmListener.onConfirm((this));
                }
                break;
        }
    }

    public interface OnCancelListener{
        void onCancel(CustomDialog dialog);
    }

    public interface OnConfirmListener{
        void onConfirm(CustomDialog dialog);
    }
}
