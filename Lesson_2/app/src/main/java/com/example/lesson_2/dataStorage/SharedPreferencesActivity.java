package com.example.lesson_2.dataStorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lesson_2.R;
import com.example.lesson_2.util.ToastUtil;

public class SharedPreferencesActivity extends AppCompatActivity {

    private Button btnSave, btnShow;
    private EditText etName;
    private TextView tvShow;
    private SharedPreferences sharedPreferences; //use to save data (save in .xml file)
    private SharedPreferences.Editor editor; //use to retrieve data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        etName = findViewById(R.id.et_name);
        btnSave = findViewById(R.id.btn_save);
        btnShow = findViewById(R.id.btn_show);
        tvShow = findViewById(R.id.tv_show);

        //Required file name and the mode (Mode can see the code), by default is MODE_PRIVATE
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                editor.putString("name", etName.getText().toString());

                //execute (save data), commit() - immediately or apply() - background
                editor.apply();

                ToastUtil.showMsg(SharedPreferencesActivity.this, "Saved");
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tvShow.setText(sharedPreferences.getString("name", ""));
            }
        });
    }
}
