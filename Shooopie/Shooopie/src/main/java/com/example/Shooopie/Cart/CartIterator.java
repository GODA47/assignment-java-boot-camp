package com.example.Shooopie.Cart;

import com.example.Shooopie.Products.Product;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

public class CartIterator implements Iterator<long[]> {

    public CartIterator(Cart packs) {
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public long[] next() {
        return new long[]{};
    }
}
