package com.example.Shooopie.Users.Responses;

public class LoginSuccessfulResponse {
    private String token;

    public LoginSuccessfulResponse(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
