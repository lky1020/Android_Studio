package com.example.lesson_2.dataStorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lesson_2.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnSharedPreferences, btnFile, btnExternalFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);

        btnSharedPreferences = findViewById(R.id.btn_sharedPreferences);
        btnFile = findViewById(R.id.btn_file);
        btnExternalFile = findViewById(R.id.btn_externalFile);

        btnSharedPreferences.setOnClickListener(this);
        btnFile.setOnClickListener(this);
        btnExternalFile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch(v.getId()){
            case R.id.btn_sharedPreferences:
                //Jump to SharedPreferencesActivity.java
                intent = new Intent(DataStorageActivity.this, SharedPreferencesActivity.class);
                break;
            case R.id.btn_file:
                //Jump to FileActivity.java
                intent = new Intent(DataStorageActivity.this, FileActivity.class);
                break;
            case R.id.btn_externalFile:
                //Jump to ExternalFileActivity.java
                intent = new Intent(DataStorageActivity.this, ExternalFileActivity.class);
                break;
        }

        startActivity(intent);
    }
}
