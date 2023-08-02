package com.mall.shopping.biz.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_category_id")
    private Long id;

    @Column(nullable = false, length = 20)
    private String categoryName;

    public static ProductCategory create(String categoryName) {
        return ProductCategory.builder().categoryName(categoryName).build();
    }


}
