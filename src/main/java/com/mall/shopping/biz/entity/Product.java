package com.mall.shopping.biz.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productCategoryId")
    private ProductCategory productCategory;

    @Column(nullable = false, length = 100)
    private String productName;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false, length = 1)
    private String soldOutYn;

    @Column(nullable = false, length = 5000)
    private String productExplanation;

    @Column(nullable = false)
    private Integer starScore;
}
