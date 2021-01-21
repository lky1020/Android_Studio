package com.example.lesson_2.dataStorage;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.lesson_2.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExternalFileActivity extends AppCompatActivity {

    private Button btnSave, btnShow;
    private EditText etName;
    private TextView tvShow;
    private final String fileName = "text.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        //Request for permission
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

        etName = findViewById(R.id.et_name);
        btnSave = findViewById(R.id.btn_save);
        btnShow = findViewById(R.id.btn_show);
        tvShow = findViewById(R.id.tv_show);

        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                save(etName.getText().toString() + "\n");
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tvShow.setText(read());
            }
        });
    }

    private void save(String content){

        FileOutputStream fileOutputStream = null;

        try{
            File dir = new File(Environment.getExternalStorageDirectory(), "lky");

            if(!dir.exists()){
                dir.mkdirs();
            }

            File file = new File(dir, fileName);

            if(!file.exists()){
                file.createNewFile();
            }

            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());

        } catch(IOException e){
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String read(){

        FileInputStream fileInputStream = null;

        try{
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "lky", fileName);
            fileInputStream = new FileInputStream(file);

            byte[] buff = new byte[1024];
            int len = 0;
            StringBuilder stringBuilder = new StringBuilder("");

            while((len = fileInputStream.read(buff)) > 0){
                stringBuilder.append(new String(buff, 0, len));
            }

            return stringBuilder.toString();

        }catch(IOException e){
            e.printStackTrace();
        }

        return null;
    }
}
