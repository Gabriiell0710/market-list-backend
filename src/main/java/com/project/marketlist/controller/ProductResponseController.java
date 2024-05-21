package com.project.marketlist.controller;

import com.project.marketlist.model.ProductResponseModel;
import com.project.marketlist.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@ToString
@CrossOrigin("*")
public class ProductResponseController {

    private List<ProductResponseModel> marketList = new ArrayList<>();
    ProductService productService;

    @PostMapping("/save")
    @ResponseBody
    public String saveMarketList(@RequestBody List<ProductResponseModel> productResponseModel){
        marketList.addAll(productResponseModel);
        productService.listaProvisoria(marketList);
        return "Lista salva com sucesso";
    }
    @GetMapping("/saved")
    @ResponseBody
    public List<ProductResponseModel> getProductsSave(){
        return marketList;
    }

    @GetMapping("/generate")
    public void marketListPdf(){
        productService.generatePDF();
    }

    public List<ProductResponseModel> getMarketList() {
        return marketList;
    }

    public void setMarketList(List<ProductResponseModel> marketList) {
        this.marketList = marketList;
    }
}


