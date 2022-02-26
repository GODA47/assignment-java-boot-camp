package com.example.Shooopie.Products;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findByproductnameContaining(String productname);
    Optional<Product> findByproductId(long productId);
}
