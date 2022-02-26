package com.example.Shooopie.Cart;

import com.example.Shooopie.Cart.Responses.CartViewResponse;
import com.example.Shooopie.Products.InvalidProductIDException;
import com.example.Shooopie.Products.Product;
import com.example.Shooopie.Products.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ProductRepo productRepo;

    public String addToCart(long userId, long[] pack) {
        Cart cart = cartRepo.findByuserId(userId);
        cart.add(pack);
        cartRepo.save(cart);
        return packtoJSON(pack);
    }

    public CartViewResponse viewCartSummary(long userId){
        Cart cart = getCart(userId);
        return new CartViewResponse(articletoPack(cart.getArticles()));
    }

    public ArrayList<ProductPack> articletoPack(ArrayList<long[]> articles){
        ArrayList<ProductPack> packs = new ArrayList<>();
        for(int i =0; i<articles.size() ;i++){
            Optional<Product> product = productRepo.findByproductId(articles.get(i)[0]);
            Product pd = product.orElseThrow(InvalidProductIDException::new);
            int quantity = (int) articles.get(i)[1];
            ProductPack pp = new ProductPack(pd,quantity);
            packs.add(pp);
        }
        return packs;
    }

    public String packtoJSON(long[] pack){
        Optional<Product> product = productRepo.findByproductId(pack[0]);
        Product pd = product.orElseThrow(InvalidProductIDException::new);
        int quantity = (int) pack[1];
        ProductPack pp = new ProductPack(pd,quantity);
        return pp.toString();
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

    public void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
}
