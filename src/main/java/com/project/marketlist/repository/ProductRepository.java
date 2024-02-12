package com.project.marketlist.repository;

import com.project.marketlist.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,Integer> {
    List<ProductModel> findAllByCategoryId(Integer categoryId);
}
