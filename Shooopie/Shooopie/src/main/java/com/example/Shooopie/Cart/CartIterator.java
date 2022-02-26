package com.example.Shooopie.Cart;

import com.example.Shooopie.Products.Product;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

public class CartIterator implements Iterator<ProductPack> {

    public CartIterator(Cart productPacks) {
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public ProductPack next() {
        return new ProductPack();
    }
}
