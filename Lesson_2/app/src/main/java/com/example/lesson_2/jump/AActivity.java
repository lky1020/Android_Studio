package com.example.lesson_2.jump;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson_2.R;

public class AActivity extends AppCompatActivity {

    private TextView tvTitle;
    private Button btnJumpToB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        Log.d("AActivity", "--- onCreate ---");
        Log.d("AActivity", "taskId: " + getTaskId() + ", hash: " + hashCode());

        logTaskName();

        btnJumpToB = findViewById(R.id.btn_jumpToB);
        btnJumpToB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //显示跳转 : 方法1
                Intent intent = new Intent(AActivity.this, BActivity.class);

                //Use Bundle to pass data
                Bundle bundle = new Bundle();
                bundle.putString("name", "lky");
                bundle.putInt("num", 1020);
                intent.putExtras(bundle);

                startActivity(intent);
                //startActivityForResult(intent, 0);  //requestCode is use to identify where to return

                //显示跳转 : 方法2
                //Intent intent = new Intent();
                //intent.setClass(AActivity.this, BActivity.class);
                //startActivity(intent);

                //显示跳转 : 方法3
                //Intent intent = new Intent();
                //intent.setClassName(AActivity.this, "com.example.lesson_2.jump.BActivity");
                //startActivity(intent);

                //显示跳转 : 方法4
                //Intent intent = new Intent();
                //intent.setComponent(new ComponentName(AActivity.this, "com.example.lesson_2.jump.BActivity"));
                //startActivity(intent);

                //隐式跳转 : 方法1 (Modify the action and category for BActivity in the manifest)
                //Intent intent = new Intent();
                //intent.setAction("com.example.lesson_2.BActivity");
                //startActivity(intent);
            }
        });

    }

    //Used when return from the B
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        tvTitle = findViewById(R.id.tv_title);

        tvTitle.setText(data.getExtras().getString("title"));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity", "--- onCreate ---");
        Log.d("AActivity", "taskId: " + getTaskId() + ", hash: " + hashCode());

        logTaskName();

    }

    private void logTaskName(){
        try{
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);

            Log.d("AActivity", info.taskAffinity);

        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
    }
}
