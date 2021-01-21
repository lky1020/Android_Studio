package com.example.lesson_2.recyclerView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lesson_2.R;

public class RecyclerViewActivity extends AppCompatActivity {

    private Button btnLinear;
    private Button btnHorizontal;
    private Button btnGrid;
    private Button btnWaterFall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        btnLinear = findViewById(R.id.btn_linear);
        btnLinear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(RecyclerViewActivity.this, LinearRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        btnHorizontal = findViewById(R.id.btn_horizontal);
        btnHorizontal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(RecyclerViewActivity.this, HorizontalRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        btnGrid = findViewById(R.id.btn_grid);
        btnGrid.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(RecyclerViewActivity.this, GridRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        btnWaterFall = findViewById(R.id.btn_waterFall);
        btnWaterFall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(RecyclerViewActivity.this, WaterFallRecyclerViewActivity.class);
                startActivity((intent));
            }

        });
    }

}
