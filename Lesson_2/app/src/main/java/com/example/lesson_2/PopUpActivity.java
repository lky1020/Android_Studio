package com.example.lesson_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class PopUpActivity extends AppCompatActivity {

    private Button btnPop;
    private PopupWindow pop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);

        btnPop = findViewById(R.id.btn_pop);
        btnPop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.layout_pop, null);
                pop = new PopupWindow(view, btnPop.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                pop.setOutsideTouchable(true);
                pop.setFocusable(true);
                pop.showAsDropDown(btnPop);
            }
        });
    }
}
