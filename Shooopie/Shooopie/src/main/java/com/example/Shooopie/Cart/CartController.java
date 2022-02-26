package com.example.Shooopie.Cart;

import com.example.Shooopie.Cart.Requests.CartAddProductRequest;
import com.example.Shooopie.Cart.Responses.CartProductAddedResponse;
import com.example.Shooopie.Cart.Responses.CartViewResponse;
import com.example.Shooopie.Products.InvalidProductIDException;
import com.example.Shooopie.Users.UserTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserTokenManager userTokenManager;





    @PostMapping(value = "/cart/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CartProductAddedResponse addProductToCart(@RequestHeader("Authorization") String token,
                                                     @RequestBody CartAddProductRequest request){
        String productadded = cartService.addToCart(userTokenManager.Token_to_id(token), request.addOrder());
        try{
            return new CartProductAddedResponse("Product added to your cart: " +
                                                productadded );
        }catch(Error e){
            throw new InvalidProductIDException();
        }
    }

    @GetMapping("/cart")
    public CartViewResponse viewCart(@RequestHeader("Authorization") String token){
        try{
            return cartService.viewCartSummary(userTokenManager.Token_to_id(token));
        }catch(Error e){
            throw new InvalidProductIDException();
        }
    }



}
