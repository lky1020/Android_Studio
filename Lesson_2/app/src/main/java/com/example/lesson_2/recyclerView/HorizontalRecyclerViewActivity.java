package com.example.lesson_2.recyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lesson_2.R;

public class HorizontalRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView rvHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_recycler_view);

        rvHorizontal = findViewById(R.id.rv_horizontal);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HorizontalRecyclerViewActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); //set the orientation for the linearLayoutManager for horizontal item
        rvHorizontal.addItemDecoration(new MyDecoration());
        rvHorizontal.setLayoutManager(linearLayoutManager);
        rvHorizontal.setAdapter(new HorizontalAdapter(HorizontalRecyclerViewActivity.this, new HorizontalAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(HorizontalRecyclerViewActivity.this, "Click: " + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    public class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, getResources().getDimensionPixelOffset(R.dimen.diverderHeight), 0);
        }
    }
}
