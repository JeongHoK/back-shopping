package com.mall.shopping.domain.product.dto;

import com.mall.shopping.domain.product.entity.Product;
import com.mall.shopping.domain.product.entity.ProductCategory;
import lombok.*;

@Data
public class ProductDto {

    private Long id;

    private ProductCategory productCategory;

    private String productName;

    private Integer price;

    private Integer stock;

    private String soldOutYn;

    private String productExplanation;

    private Integer starScore;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.productCategory = product.getProductCategory();
        this.productName = product.getProductName();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.soldOutYn = product.getSoldOutYn();
        this.productExplanation = product.getProductExplanation();
        this.starScore = product.getStarScore();
    }



}
