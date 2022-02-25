package com.example.Shooopie.Users;

import com.example.Shooopie.Users.Exceptions.InvalidLoginInfoException;
import com.example.Shooopie.Users.Responses.LoginSuccessfulResponse;
import com.example.Shooopie.Users.Responses.UserProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginSuccessfulResponse login(@RequestBody LoginRequest request){
        String token = userService.login(request.getUsername(), request.getPassword());
        return new LoginSuccessfulResponse(token);
    }

    @GetMapping("/user/myPage")
    public UserProfileResponse getProfile(@RequestHeader("Authorization") String token){
        try{
            return userService.myPage(token);
        } catch(Exception e){
            throw new InvalidLoginInfoException();
        }
    }
}
