package com.mall.shopping.domain.product.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id")
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

    public static Product create(ProductCategory productCategory, String productName, Integer price, Integer stock, String productExplanation) {

        String soldOutYn = stock > 0 ? "N" : "Y";

        if(price < 0) {
            throw new IllegalStateException("상품의 가격은 0원이하로 입력할 수 없습니다.");
        }

        if(stock < 0) {
            throw new IllegalStateException("재고 값은 0개 이하로 입력할 수 없습니다.");
        }

        return Product.builder()
                .productCategory(productCategory)
                .productName(productName)
                .price(price)
                .stock(stock)
                .soldOutYn(soldOutYn)
                .productExplanation(productExplanation)
                .starScore(0)
                .build();
    }

}
