package com.example.lesson_2.gridView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson_2.R;

public class GridViewActivity extends AppCompatActivity {

    private GridView gv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gv = findViewById(R.id.gv);
        gv.setAdapter(new MyGridAdapter(GridViewActivity.this));

        //Click
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, "Post: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        //Press
        gv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, "Press: " + position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
