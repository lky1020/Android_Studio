package com.example.mark1.object;

import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class Validation {

    private EditText etUsername, etEmail;
    private TextInputLayout layoutPassword; // use to set the visibility of password toggle to prevent duplicated with the set error icon
    private String regexInput = "^[a-zA-Z0-9].{5,}$";

    public Validation(){}

    //Login
    public Validation(EditText etUsername, TextInputLayout layoutPassword){

        this.etUsername = etUsername;
        this.layoutPassword = layoutPassword;
    }

    //SignUp
    public Validation(EditText etUsername, EditText etEmail, TextInputLayout layoutPassword){

        this.etUsername = etUsername;
        this.etEmail = etEmail;
        this.layoutPassword = layoutPassword;
    }

    public boolean validateUsername(String username){

        if(username.isEmpty()){
            etUsername.setError("Username cannot be empty");
            return false;

        }else if(!username.matches(regexInput)){
            etUsername.setError("Please Enter At Least 6 Characters");
            return false;

        }else if(username.contains(" ")){
            etUsername.setError("Spaces is not allowed");
            return false;
        }

        return true;
    }

    public boolean validateEmail(String email){

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(email.isEmpty()){
            etEmail.setError("Email cannot be empty");
            return false;

        }else if(!email.matches(emailPattern)){
            etEmail.setError("Invalid Email Format");
            return false;

        }else if(!email.matches(regexInput)){
            etEmail.setError("Please Enter At Least 6 Characters");
            return false;

        }else if(email.contains(" ")){
            etEmail.setError("Spaces is not allowed");
            return false;
        }

        return true;
    }

    public boolean validatePassword(String password){

        if(password.isEmpty()){
            layoutPassword.setError("Password cannot be empty");
            return false;

        }else if(!password.matches(regexInput)) {
            layoutPassword.setError("Please Enter At Least 6 Characters");
            return false;

        }else if(password.contains(" ")){
            layoutPassword.setError("Spaces is not allowed");
            return false;
        }

        layoutPassword.setError(null);
        layoutPassword.setErrorEnabled(false);
        return true;
    }
}
