package com.example.Shooopie.Cart;

import com.example.Shooopie.Products.Product;
import com.example.Shooopie.Products.ProductIterator;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

@Entity
public class Cart implements Iterable<long[]>{
    @Id
    private long userId;
    private ArrayList<long[]> articles;

    public Cart() {
    }

    public Cart(long userId) {
        this.userId = userId;
        articles =  new ArrayList<>();
    }

    public void add(long[] pack) {
        articles.add(pack);
    }

    public long getUserId() {
        return userId;
    }

    public ArrayList<long[]> getArticles() {
        return articles;
    }


    @Override
    public Iterator<long[]> iterator() {
        return new CartIterator(this);
    }

    @Override
    public void forEach(Consumer<? super long[]> action) {
        Iterable.super.forEach(action);
    }
}
