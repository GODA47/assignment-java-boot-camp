package com.example.Shooopie.Users.Exceptions;

public class InvalidLoginInfoException extends RuntimeException {
    public InvalidLoginInfoException(){
        super("Invalid username or password");
    }

}
