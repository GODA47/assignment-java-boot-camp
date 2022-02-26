package com.example.Shooopie.Products;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductList implements Iterable<Product>{
    private List<Product> productList;

    public ProductList(){
        productList = new ArrayList<>();
    }

    public void add(Product product) {
        productList.add(product);
    }

    public Product get(int index){
        return productList.get(index);
    }

    public int length(){
        return productList.size();
    }

    public List<Product> getProductList(){
        return productList;
    }

    @Override
    public Iterator<Product> iterator() {
        return new ProductIterator(this);
    }

    @Override
    public boolean equals(Object otherObj){
        if(otherObj instanceof ProductList){
            return this.productList.equals(((ProductList) otherObj).productList);
        }
        return false;
    }


}
