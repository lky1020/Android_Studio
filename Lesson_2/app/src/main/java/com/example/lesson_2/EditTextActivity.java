package com.example.lesson_2;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class EditTextActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private RadioGroup rg1;
    private RadioGroup rg2;
    private Button btnLogin;
    private TextView tv1;
    private CheckBox ck1;
    private CheckBox ck2;
    private CheckBox ck3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        //Show effect for the username
        editTextUsername = findViewById(R.id.et_1);
        editTextUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("editText", toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //do nothing
            }
        });

        //Press and prompt message for radio group 1
        rg1 = findViewById(R.id.rg_1);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId){
                RadioButton radioButton = group.findViewById(checkedId);
                Toast.makeText(EditTextActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        //Let word marquee
        tv1 = findViewById(R.id.tv_1);
        tv1.setSelected(true);

        //Press and prompt message for radio group 2
        rg2 = findViewById(R.id.rg_2);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId){
                RadioButton radioButton = group.findViewById(checkedId);

                if(radioButton.getText().equals("Yes")){
                    Toast.makeText(EditTextActivity.this, "You will receive email!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(EditTextActivity.this, "You wouldn't receive email!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Press and prompt message for checkbox
        ck1 = findViewById(R.id.ck_1);
        ck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(EditTextActivity.this, "English", Toast.LENGTH_SHORT).show();
            }
        });

        ck2 = findViewById(R.id.ck_2);
        ck2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(EditTextActivity.this, "Chinese", Toast.LENGTH_SHORT).show();
            }
        });

        ck3 = findViewById(R.id.ck_3);
        ck3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(EditTextActivity.this, "Indo", Toast.LENGTH_SHORT).show();
            }
        });

        //Login and prompt message
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(EditTextActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
