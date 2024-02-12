package com.project.marketlist.controller;

import com.project.marketlist.model.ProductModel;
import com.project.marketlist.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class ProductController {

    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.listAllProducts());
    }

    @GetMapping("/products/category/{categoryId}")
    public ResponseEntity<List<ProductModel>> getProductByCategory (@PathVariable (value="categoryId") Integer categoryId){
        return ResponseEntity.status(HttpStatus.OK).body(productService.listAllProductsByCategory(categoryId));
    }
}
