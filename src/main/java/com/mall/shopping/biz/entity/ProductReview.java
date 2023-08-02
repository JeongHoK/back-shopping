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
public class ProductReview {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private User user;

    @Column(nullable = false, length = 500)
    private String review;

    @Column(nullable = false)
    private Integer starScore;
}
