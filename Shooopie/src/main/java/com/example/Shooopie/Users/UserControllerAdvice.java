package com.example.Shooopie.Users;

import com.example.Shooopie.Users.Exceptions.InvalidLoginInfoException;
import com.example.Shooopie.Users.Responses.LoginFailureResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {
    @ExceptionHandler(InvalidLoginInfoException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public LoginFailureResponse loginfailure(InvalidLoginInfoException e){
        return new LoginFailureResponse(e.getMessage());
    }
}
