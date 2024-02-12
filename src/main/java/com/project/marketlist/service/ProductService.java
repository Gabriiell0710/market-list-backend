package com.project.marketlist.service;

import com.project.marketlist.model.ProductModel;
import com.project.marketlist.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public List<ProductModel> listAllProducts(){
        return productRepository.findAll();
    }

    public List<ProductModel> listAllProductsByCategory(Integer categoryId){
        return productRepository.findAllByCategoryId(categoryId);
    }


}
