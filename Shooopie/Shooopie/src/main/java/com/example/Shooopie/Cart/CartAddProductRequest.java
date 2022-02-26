package com.example.Shooopie.Cart;

import com.example.Shooopie.JsonConvertible;
import org.json.JSONException;
import org.json.JSONObject;

public class CartAddProductRequest implements JsonConvertible {
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

    public ProductPack addOrder() {
        return new ProductPack(productId, quantity);
    }
}
