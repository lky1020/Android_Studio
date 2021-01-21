package com.example.lesson_2.recyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.lesson_2.R;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView rvGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);

        rvGrid = findViewById(R.id.rv_grid);
        rvGrid.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this, 3)); // one row show 3 column
        rvGrid.setAdapter(new GridAdapter(GridRecyclerViewActivity.this, new GridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this, "Click: " + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
