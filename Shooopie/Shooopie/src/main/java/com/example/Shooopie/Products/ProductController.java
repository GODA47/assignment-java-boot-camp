package com.example.Shooopie.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    @ResponseBody
    public ProductList keywordSearch(@RequestParam String keyword){
        return productService.productKeywordSearch(keyword);
    }

    @GetMapping("/product/{productId}")
    @ResponseBody
    public Product showProductFromId(@PathVariable long productId){
        try {
            return productService.getProduct(productId);
        } catch(Exception e){
            throw new InvalidProductIDException();
        }
    }
}
