package com.example.Shooopie.Cart;

import com.example.Shooopie.Products.Product;
import com.example.Shooopie.Products.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;


public class ProductPack {

    private Product product;
    private int quantity;
    private String productname;
    private double price;

    public ProductPack(){

    }

    public ProductPack(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
        this.productname = product.getProductname();
        this.price = product.getPrice();
    }

    @Override
    public String toString() {
        return "ProductPack{" +
                "product=" + product +
                ", productname='" + productname + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getProductId() {
        return product.getProductId();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
