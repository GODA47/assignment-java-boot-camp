package com.example.Shooopie.Cart.Requests;

import com.example.Shooopie.JsonConvertible;
import com.example.Shooopie.Products.ProductService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

public class CartAddProductRequest implements JsonConvertible {
    @Autowired
    private ProductService productService;

    private long productId;
    private int quantity;

    public CartAddProductRequest(long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override
    public String toJson() {
        JSONObject json = new JSONObject();
        try{
            json.put("productId", productId);
            json.put("quantity", quantity);
        } catch(JSONException e){
            e.printStackTrace();
            return null;
        }
        return json.toString();
    }

    public long getProductId() {
        return productId;
    }
    public int getQuantity() {
        return quantity;
    }

    public long[] addOrder() {
        return new long[]{productId, (long) quantity};
    }
}
