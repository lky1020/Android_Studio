package com.example.lesson_2.listView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.lesson_2.R;

public class ListViewActivity extends Activity {

    private ListView lv1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lv1 = findViewById(R.id.lv_1);
        lv1.setAdapter(new MyListAdapter(ListViewActivity.this));

        //for click
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "Post: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        //for press
        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "Press: " + position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}
