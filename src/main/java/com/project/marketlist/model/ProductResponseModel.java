package com.project.marketlist.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
public class ProductResponseModel {

    private String productName;
    private Integer productQtd;
    private String categoryName;

    public ProductResponseModel() {
    }

    public ProductResponseModel(String productName, Integer productQtd, String categoryName) {
        this.productName = productName;
        this.productQtd = productQtd;
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductQtd() {
        return productQtd;
    }

    public void setProductQtd(Integer productQtd) {
        this.productQtd = productQtd;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
