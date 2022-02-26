package com.example.Shooopie.Users.Responses;

import com.example.Shooopie.Users.User;

import java.util.Optional;

public class UserProfileResponse {

    private String username;

    public UserProfileResponse(User user){
        setUsername(user.getUsername());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
