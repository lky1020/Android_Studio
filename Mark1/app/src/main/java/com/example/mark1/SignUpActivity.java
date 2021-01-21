package com.example.mark1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mark1.object.Users;
import com.example.mark1.object.Validation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {

    private EditText etUsername, etEmail;
    private TextInputLayout layoutPassword; // only do for the password for the TextInputLayout (Lazy~~~)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUsername = findViewById(R.id.et_signUpUsername);
        etEmail = findViewById(R.id.et_signUpEmail);
        layoutPassword = findViewById(R.id.layout_signup_password);
    }

    public void signUp(View v){

        Validation validation = new Validation(etUsername, etEmail, layoutPassword);

        final String username = etUsername.getText().toString().trim();
        final String email = etEmail.getText().toString().trim();
        final String password = Objects.requireNonNull(layoutPassword.getEditText()).getText().toString().trim();

        boolean validUsername = validation.validateUsername(username);
        boolean validEmail = validation.validateEmail(email);
        boolean validPassword = validation.validatePassword(password);

        //Pass Validation
        if(validUsername && validEmail && validPassword){
            final FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
            final DocumentReference usersRef = firebaseFirestore.collection("Users").document(username);
            CollectionReference usersCollectionRef = firebaseFirestore.collection("Users");

            final boolean[] duplicateUsername = {false};
            final boolean[] duplicatePassword = {false};

            usersCollectionRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                    for(QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                        Users validUsers = documentSnapshot.toObject(Users.class);

                        if(username.equals(validUsers.getUsername())){
                            duplicateUsername[0] = true;
                            System.out.println(username);
                        }

                        if(email.equals(validUsers.getEmail())){
                            duplicatePassword[0] = true;
                            System.out.println(email);
                        }
                    }

                    if(duplicateUsername[0] || duplicatePassword[0]){
                        if(duplicateUsername[0]){
                            etUsername.setError("Username have been Taken !!!");
                        }

                        if(duplicatePassword[0]){
                            etEmail.setError("Email have been Taken !!!");
                        }
                    }else{
                        Users users = new Users();
                        users.setUsername(username);
                        users.setEmail(email);
                        users.setPassword(password);
                        users.setCreatedDate(new Date());

                        usersRef.set(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    etUsername.getText().clear();
                                    etEmail.getText().clear();
                                    layoutPassword.getEditText().getText().clear();
                                    Toast.makeText(SignUpActivity.this, "Signed Up", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(SignUpActivity.this, "Failed to Sign Up", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            });

        }
    }
}
