package com.example.Shooopie.Cart;

import com.example.Shooopie.Products.Product;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

@Entity
public class Cart implements Iterable<ProductPack>{
    @Id
    private long userId;
    private ArrayList<ProductPack> articles;

    public Cart() {
    }

    public Cart(long userId) {
        this.userId = userId;
        articles =  new ArrayList<>();
    }

    public void add(ProductPack pack) {
        articles.add(pack);
    }

    public long getUserId() {
        return userId;
    }

    public ArrayList<ProductPack> getArticles() {
        return articles;
    }

    @Override
    public Iterator<ProductPack> iterator() {
        return new CartIterator(this);
    }

    @Override
    public void forEach(Consumer<? super ProductPack> action) {
        Iterable.super.forEach(action);
    }
}
