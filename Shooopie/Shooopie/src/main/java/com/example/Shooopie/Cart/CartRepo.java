package com.example.Shooopie.Cart;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepo extends JpaRepository<Cart, Integer> {
    Cart findByuserId(long userId);

    void deleteByuserId(long userId);

    boolean existsByUserId(long userId);
}
