package com.example.Shooopie.Users.Responses;

public class LoginFailureResponse {
    private String message;

    public LoginFailureResponse(){

    }
    public LoginFailureResponse(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}
