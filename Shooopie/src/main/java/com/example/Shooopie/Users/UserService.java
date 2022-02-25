package com.example.Shooopie.Users;

import com.example.Shooopie.Users.Exceptions.InvalidLoginInfoException;
import com.example.Shooopie.Users.Responses.UserProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserTokenManager userTokenManager;


    public void registerUser(String username, String password){
        User user = new User(username, password);
        userRepo.save(user);
    }
    public String login(String username,String password){
        Optional<User> registeredUser = userRepo.findByUsername(username);
        if(registeredUser.isPresent()){
            if(registeredUser.get().getPassword().equals(password)) {
                return userTokenManager.id_to_Token(registeredUser.get().getUserId());
            }
        }
        throw new InvalidLoginInfoException();
    }

    public UserProfileResponse myPage(String token){
        long id = getIdfromToken(token);
        Optional<User> registeredUser = userRepo.findByUserId(id);
        return new UserProfileResponse(registeredUser.get());
    }

    public User getUserfromId(long id){
        Optional<User> registeredUser = userRepo.findByUserId(id);
        if(registeredUser.isPresent()){
            return registeredUser.get();
        }
        throw new InvalidLoginInfoException();
    }

    public long getIdfromToken(String token){
        return userTokenManager.Token_to_id(token);
    }

    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void setUserTokenManager(UserTokenManager userTokenManager) {
        this.userTokenManager = userTokenManager;
    }
}
