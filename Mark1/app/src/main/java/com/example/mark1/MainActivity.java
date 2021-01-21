package com.example.mark1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mark1.object.Users;
import com.example.mark1.object.Validation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername;
    private TextInputLayout layoutPassword;
    private SharedPreferences sharedPreferences; //use to save data (save in .xml file)
    private SharedPreferences.Editor editor; //use to retrieve data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_loginUsername);
        layoutPassword = findViewById(R.id.layout_login_password);

        /*sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.putString("username", "lky1020");
        editor.putString("password", "lky1020");
        editor.apply();

        Toast.makeText(this, "Saved Username & Password", Toast.LENGTH_SHORT).show();*/

        //For Easy Purpose
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        etUsername.setText(sharedPreferences.getString("username", ""));
        layoutPassword.getEditText().setText(sharedPreferences.getString("password", ""));

        FloatingActionButton btnLogin = findViewById(R.id.floating_login);
        btnLogin.performClick();
    }

    public void processLogin(View v){

        Validation validation = new Validation(etUsername, layoutPassword);

        final String username = etUsername.getText().toString().trim();
        final String password = layoutPassword.getEditText().getText().toString().trim();

        boolean validUsername = validation.validateUsername(username);
        boolean validPassword = validation.validatePassword(password);

        if (validUsername && validPassword){
            FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
            CollectionReference usersRef = firebaseFirestore.collection("Users");

            usersRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                    boolean validUser = false;

                    for(QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                        Users users = documentSnapshot.toObject(Users.class);

                        if(username.equals(users.getUsername()) && password.equals(users.getPassword())){
                            validUser = true;
                        }
                    }

                    if(validUser){

                        etUsername.getText().clear();
                        layoutPassword.getEditText().getText().clear();

                        Toast.makeText(MainActivity.this, "Signed In", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this, HomeMainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Invalid User", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }

    public void openSignUp(View v){
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }

    public void openForgotPassword(View v){
        //startActivity(new Intent(MainActivity.this, SignUpActivity.class));
        Toast.makeText(this, "Testing", Toast.LENGTH_SHORT).show();
    }
}
