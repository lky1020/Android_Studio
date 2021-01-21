package com.example.lesson_2;
import com.example.lesson_2.gridView.GridViewActivity;
import com.example.lesson_2.listView.ListViewActivity;
import com.example.lesson_2.recyclerView.RecyclerViewActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnTextView;
    private Button btnButton;
    private Button btnEditText;
    private Button btnImageView;
    private Button btnListView;
    private Button btnGridView;
    private Button btnRecyclerView;
    private Button btnWebView;
    private Button btnToast;
    private Button btnDialog;
    private Button btnProgress;
    private Button btnCustomDialog;
    private Button btnPopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTextView = findViewById(R.id.btn_textview);
        btnButton = findViewById(R.id.btn_button);
        btnEditText = findViewById(R.id.btn_editText);
        btnImageView = findViewById(R.id.btn_imageView);
        btnListView = findViewById(R.id.btn_listView);
        btnGridView = findViewById(R.id.btn_gridView);
        btnRecyclerView = findViewById(R.id.btn_recyclerView);
        btnWebView = findViewById(R.id.btn_webView);
        btnToast = findViewById(R.id.btn_toast);
        btnDialog = findViewById(R.id.btn_dialog);
        btnProgress = findViewById(R.id.btn_progress);
        btnCustomDialog = findViewById(R.id.btn_customDialog);
        btnPopUp = findViewById(R.id.btn_popup);
        setListeners();
    }

    private void setListeners(){
        OnClick onClick = new OnClick();
        btnTextView.setOnClickListener(onClick);
        btnButton.setOnClickListener(onClick);
        btnEditText.setOnClickListener(onClick);
        btnImageView.setOnClickListener(onClick);
        btnListView.setOnClickListener(onClick);
        btnGridView.setOnClickListener(onClick);
        btnRecyclerView.setOnClickListener(onClick);
        btnWebView.setOnClickListener(onClick);
        btnToast.setOnClickListener(onClick);
        btnDialog.setOnClickListener(onClick);
        btnProgress.setOnClickListener(onClick);
        btnCustomDialog.setOnClickListener(onClick);
        btnPopUp.setOnClickListener(onClick);
    }

    public class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_textview:
                    //Jump to TextViewActivity.java (TextView)
                    intent = new Intent(MainActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    //Jump to ButtonActivity.java (Button)
                    intent = new Intent(MainActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_editText:
                    //Jump to EditTextActivity.java (EditText, Radio Button, Check Box)
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_imageView:
                    //Jump to ImageViewActivity.java (EditText, Radio Button, Check Box)
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_listView:
                    //Jump to ListViewActivity.java (EditText, Radio Button, Check Box)
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_gridView:
                    //Jump to GridViewActivity.java (EditText, Radio Button, Check Box)
                    intent = new Intent(MainActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_recyclerView:
                    //Jump to RecyclerViewActivity.java (EditText, Radio Button, Check Box)
                    intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.btn_webView:
                    //Jump to WebViewActivity.java (EditText, Radio Button, Check Box)
                    intent = new Intent(MainActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_toast:
                    //Jump to ToastActivity.java (EditText, Radio Button, Check Box)
                    intent = new Intent(MainActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_dialog:
                    //Jump to DialogActivity.java (EditText, Radio Button, Check Box)
                    intent = new Intent(MainActivity.this, DialogActivity.class);
                    break;
                case R.id.btn_progress:
                    //Jump to ProgressActivity.java (EditText, Radio Button, Check Box)
                    intent = new Intent(MainActivity.this, ProgressActivity.class);
                    break;
                case R.id.btn_customDialog:
                    //Jump to CustomDialogActivity.java (EditText, Radio Button, Check Box)
                    intent = new Intent(MainActivity.this, CustomDialogActivity.class);
                    break;
                case R.id.btn_popup:
                    //Jump to PopUpActivity.java (EditText, Radio Button, Check Box)
                    intent = new Intent(MainActivity.this, PopUpActivity.class);
                    break;
            }

            startActivity(intent);
        }

    }

}
