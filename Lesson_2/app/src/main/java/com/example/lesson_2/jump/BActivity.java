package com.example.lesson_2.jump;

import android.app.Activity;
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

public class BActivity extends AppCompatActivity {

    private TextView tvTitle;
    private Button btnJumpToA;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Log.d("AActivity", "--- onCreate ---");
        Log.d("AActivity", "taskId: " + getTaskId() + ", hash: " + hashCode());

        logTaskName();

        tvTitle = findViewById(R.id.tv_title);
        btnJumpToA = findViewById(R.id.btn_jumpToA);

        Bundle bundle = getIntent().getExtras();
        final String name = bundle.getString("name");
        final int num = bundle.getInt("num");

        tvTitle.setText(name + num);

        //Return to A Activity
        btnJumpToA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                Bundle bundle1 = new Bundle();
                bundle1.putString("title", "Hi " + name + num);
                intent.putExtras(bundle1);

                //Return
                setResult(Activity.RESULT_OK, intent);
                finish();   //close BActivity
            }
        });
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

            Log.d("BActivity", info.taskAffinity);

        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
    }
}
