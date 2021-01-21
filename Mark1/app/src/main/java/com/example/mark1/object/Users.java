package com.example.mark1.object;

import java.util.Date;

public class Users {
    private String username, email, password;
    private Date createdDate;

    public Users(){}

    public Users(String username, String email, String password, Date createdDate) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdDate = createdDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
