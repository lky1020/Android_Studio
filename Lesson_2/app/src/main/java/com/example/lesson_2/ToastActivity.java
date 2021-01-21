package com.example.lesson_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lesson_2.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {

    private Button btnToast1;
    private Button btnToast2;
    private Button btnToast3;
    private Button btnToast4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        btnToast1 = findViewById(R.id.btn_toast1);
        btnToast2 = findViewById(R.id.btn_toast2);
        btnToast3 = findViewById(R.id.btn_toast3);
        btnToast4 = findViewById(R.id.btn_toast4);

        OnClick onClick = new OnClick();
        btnToast1.setOnClickListener(onClick);
        btnToast2.setOnClickListener(onClick);
        btnToast3.setOnClickListener(onClick);
        btnToast4.setOnClickListener(onClick);

    }

    public class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.btn_toast1:
                    Toast.makeText(getApplicationContext(), "Toast 1", Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_toast2:
                    Toast toastCenter = Toast.makeText(getApplicationContext(), "Center Toast", Toast.LENGTH_LONG);
                    toastCenter.setGravity(Gravity.CENTER, 0, 0);
                    toastCenter.show();
                    break;
                case R.id.btn_toast3:
                    //use inflater to show the custom layout
                    Toast toastCustom = new Toast(getApplicationContext());
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    View view = inflater.inflate(R.layout.layout_toast, null);

                    ImageView imageView = view.findViewById(R.id.iv_toast);
                    TextView textView = view.findViewById(R.id.tv_toast);

                    imageView.setImageResource(R.drawable.smile_icon);
                    textView.setText("自定义Toast");

                    toastCustom.setView(view);
                    toastCustom.setDuration(Toast.LENGTH_LONG);
                    toastCustom.show();
                    break;
                case R.id.btn_toast4:
                    //to prevent the toast wait for others (eg: will prevent show all 20 toast after press 20 times, only show one time)
                    ToastUtil.showMsg(getApplicationContext(), "包装过的Toast");
                    break;
            }
        }
    }
}
