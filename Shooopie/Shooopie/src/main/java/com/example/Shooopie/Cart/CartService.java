package com.example.Shooopie.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;


    public void addToCart(long userId, ProductPack pack) {
        Cart cart = cartRepo.findByuserId(userId);
        cart.add(pack);
    }

    public Cart getCart(long userId){
        return cartRepo.findByuserId(userId);
    }

    public void clearCart(long userId){
        cartRepo.deleteByuserId(userId);
        cartRepo.save(new Cart(userId));
    }

    public void setCartRepo(CartRepo cartRepo){
        this.cartRepo = cartRepo;
    }
}
