package com.example.Shooopie.Users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    public Optional<User> findByUsername(String username);
    public Optional<User> findByUserId(long userId);
}
