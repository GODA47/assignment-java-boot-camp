package com.example.Shooopie.Users;

import org.springframework.stereotype.Component;

@Component
public class UserTokenManager {

    public String id_to_Token(long user_id){
        return Long.toHexString(user_id);
    }

    public long Token_to_id(String token){
        return Long.parseLong(token);
    }
}
