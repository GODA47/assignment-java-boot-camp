package com.example.Shooopie.Products;

public class InvalidProductIDException extends RuntimeException{
    public InvalidProductIDException(){
        super("Invalid product ID.");
    }
}
