package com.example.lesson_2.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lesson_2.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IONMessageClick{

    private Fragment aFragment;
    private TextView tvTitle;
    //private Fragment bFragment;
    //private Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        tvTitle = findViewById(R.id.tv_title);

        /*btnChange = findViewById(R.id.btn_change); //Change to BFragment
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //实例化BFragment
                if(bFragment == null){
                    bFragment = new BFragment();
                }
                //把BFragment添加到Activity中
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).commitAllowingStateLoss();
            }
        });*/

        //实例化AFragment
        aFragment = AFragment.newInstance("lky1020");
        //把AFragment添加到Activity中
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, aFragment, "a").commitAllowingStateLoss();

    }

    public void setData(String text){
        tvTitle.setText(text);
    }

    @Override
    public void onClick(String text){
        tvTitle.setText(text);
    }

}

