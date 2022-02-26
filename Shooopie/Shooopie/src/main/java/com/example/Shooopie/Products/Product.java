package com.example.Shooopie.Products;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private long productId;

    private String productname;
    private String description;
    private String brand;
    private String color;
    private double price;

    public Product() {
    }

    public Product(String productname,
                   String description,
                   String brand,
                   String color,
                   double price){
        setProductname(productname);
        setDescription(description);
        setBrand(brand);
        setColor(color);
        setPrice(price);
    }

    @Override
    public boolean equals(Object otherObj){
        if (otherObj != null && otherObj instanceof Product){
            if(otherObj == this){
                return true;
            }
            Product product = (Product) otherObj;
            return Objects.equals(productId, product.productId) && Objects.equals(productname, product.productId) &&
                    Objects.equals(price, product.price) && Objects.equals(color, product.color);
        }
        return false;
    }



    public long getProductId() {
        return productId;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
