package com.example.lesson_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lesson_2.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {

    private Button btnDialog1, btnDialog2, btnDialog3, btnDialog4, btnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        btnDialog1 = findViewById(R.id.btn_dialog1);
        btnDialog2 = findViewById(R.id.btn_dialog2);
        btnDialog3 = findViewById(R.id.btn_dialog3);
        btnDialog4 = findViewById(R.id.btn_dialog4);
        btnDialog5 = findViewById(R.id.btn_dialog5);

        OnClick onClick = new OnClick();
        btnDialog1.setOnClickListener(onClick);
        btnDialog2.setOnClickListener(onClick);
        btnDialog3.setOnClickListener(onClick);
        btnDialog4.setOnClickListener(onClick);
        btnDialog5.setOnClickListener(onClick);
    }

    public class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {

            AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);

            switch(v.getId()){
                case R.id.btn_dialog1:
                    builder.setTitle("请回答").setMessage("你觉得课程如何？")
                            .setIcon(R.drawable.user_icon)
                            .setPositiveButton("棒", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, "你很棒!");
                                }
                            }).setNeutralButton("还可以", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, "你很不错!");
                                }
                            }).setNegativeButton("不可以", new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, "非常抱歉!");
                                }
                            }).show();
                    break;
                case R.id.btn_dialog2:
                    final String[] array_1 = new String[]{"男", "女"};

                    builder.setTitle("选择性别").setItems(array_1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this, array_1[which]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog3:
                    final String[] array_2 = new String[]{"男", "女"};

                    builder.setTitle("选择性别")
                            .setSingleChoiceItems(array_2, 0, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, array_2[which]);

                                    //To dismiss the dialog for the setCancelable (Prevent user cancel the dialog without choice the gender)
                                    dialog.dismiss();
                                }
                            }).setCancelable(false).show();
                    break;
                case R.id.btn_dialog4:
                    final String[] array_3 = new String[]{"唱歌", "跳舞", "写代码"};
                    boolean[] isSelected = new boolean[]{false, false, true};

                    builder.setTitle("选择兴趣").setMultiChoiceItems(array_3, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(DialogActivity.this, array_3[which] + ": " + isChecked);
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
                    break;
                case R.id.btn_dialog5:
                    View view = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog, null);

                    Button btnLogin = view.findViewById(R.id.btn_login);

                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ToastUtil.showMsg(DialogActivity.this, "Logged In!");
                        }
                    });

                    builder.setTitle("请先登录").setView(view).show();
                    break;
            }
        }
    }
}
