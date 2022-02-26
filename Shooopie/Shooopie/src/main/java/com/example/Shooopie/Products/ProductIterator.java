package com.example.Shooopie.Products;

import java.util.Iterator;

public class ProductIterator implements Iterator<Product> {
    public ProductIterator(ProductList productList){

    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Product next() {
        return new Product();
    }
}
