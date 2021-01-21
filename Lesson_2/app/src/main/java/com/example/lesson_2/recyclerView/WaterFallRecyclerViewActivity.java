package com.example.lesson_2.recyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lesson_2.R;

public class WaterFallRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView rvWaterFall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_fall_recycler_view);

        rvWaterFall = findViewById(R.id.rv_waterFall);
        rvWaterFall.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rvWaterFall.addItemDecoration(new MyDecoration());
        rvWaterFall.setAdapter(new WaterFallAdapter(WaterFallRecyclerViewActivity.this, new WaterFallAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(WaterFallRecyclerViewActivity.this, "Click: " + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    public class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
            super.getItemOffsets(outRect, view, parent, state);

            int gap = getResources().getDimensionPixelSize(R.dimen.diverderHeight2);
            outRect.set(gap, gap, gap, gap);
        }
    }
}
