package com.project.marketlist.controller;

import com.project.marketlist.dto.ProductResponseDto;
import com.project.marketlist.model.ProductResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class ProductResponseController {

    private List<ProductResponseModel> marketList = new ArrayList<>();

    @PostMapping("/products")
    public String saveMarketList(@RequestBody ProductResponseDto productDto){
       var newList = new ProductResponseModel();
        BeanUtils.copyProperties(productDto, newList);
        marketList.addAll((Collection<? extends ProductResponseModel>) newList);
        return "Lista salva com sucesso";
    }
}
