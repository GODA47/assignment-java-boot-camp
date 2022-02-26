package com.example.Shooopie.Cart;

public class ProductPack {
    private long productId;
    private int quantity;

    public ProductPack(){

    }
    public ProductPack(long productId, int quantity){
        this.productId = productId;
        this.quantity = quantity;
    }

    public long getProductId() {
        return productId;
    }

    public void setProduct(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
