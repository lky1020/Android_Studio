package com.example.lesson_2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson_2.fragment.ContainerActivity;
import com.example.lesson_2.jump.AActivity;

public class TestActivity extends AppCompatActivity {

    private Button btnJump;
    private Button btnFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Log.d("LifeCycle", "----onCreate----");

        btnJump = findViewById(R.id.btn_jump);
        btnFragment = findViewById(R.id.btn_fragment);
        setListeners();
    }

    private void setListeners(){
        OnClick onClick = new OnClick();

        btnJump.setOnClickListener(onClick);
        btnFragment.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;

            switch(v.getId()){
                case R.id.btn_jump:
                    //Jump to AActivity.java (TextView)
                    intent = new Intent(TestActivity.this, AActivity.class);
                    break;
                case R.id.btn_fragment:
                    //Jump to ContainerActivity.java (TextView)
                    intent = new Intent(TestActivity.this, ContainerActivity.class);
                    break;
            }

            startActivity(intent);
        }
    }

    //Lesson 4.1.2 Activity的生命周期
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "----onStart----");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle", "----onResume----");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "----onPause----");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle", "----onStop----");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle", "----onRestart----");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "----onDestroy----");
    }
}
