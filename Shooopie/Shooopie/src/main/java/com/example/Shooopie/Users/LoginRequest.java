package com.example.Shooopie.Users;

import com.example.Shooopie.JsonConvertible;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginRequest implements JsonConvertible {
    private String username;
    private String password;


    @Override
    public String toJson() {
        JSONObject json = new JSONObject();
        try{
            json.put("username", username);
            json.put("password", password);
        } catch(JSONException e){
            e.printStackTrace();
            return null;
        }
        return json.toString();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
