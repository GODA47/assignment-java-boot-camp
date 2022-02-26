package com.example.Shooopie.Cart;

import com.example.Shooopie.Users.UserTokenManager;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

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
        cartService.addToCart(userTokenManager.Token_to_id(token), request.addOrder());
        return new CartProductAddedResponse("Product added to your cart");
    }

}
