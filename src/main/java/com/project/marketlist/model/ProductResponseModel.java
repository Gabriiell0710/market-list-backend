package com.project.marketlist.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseModel {

    private String productName;
    private Integer productQtd;

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
}
