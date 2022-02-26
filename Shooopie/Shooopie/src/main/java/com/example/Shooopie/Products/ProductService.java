package com.example.Shooopie.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public void registerProduct(String productname, String description, String brand, String color, double price) {
        Product newProduct = new Product(productname, description, brand, color, price);
        productRepo.save(newProduct);
    }

    public ProductList productKeywordSearch(String keyword) {
        List<Product> productList = productRepo.findByproductnameContaining(keyword);
        ProductList searchResult = new ProductList();
        for(Product product: productList){
            searchResult.add(product);
        }
        return searchResult;
    }

    public Product getProduct(long productId) {
        Optional<Product> product = productRepo.findByproductId(productId);
        return product.get();
    }

    public void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
}
