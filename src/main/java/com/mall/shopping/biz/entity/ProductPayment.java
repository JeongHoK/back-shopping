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
public class ProductPayment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_payment_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_order_id")
    private ProductOrder productOrder;

    @Column(nullable = false)
    private Integer orderPrice;

    @Column(nullable = false)
    private Integer paymentPrice;

    @Column(nullable = false)
    private Integer pointUsePrice;

    @Column(nullable = false)
    private Integer discountPrice;

    @Column(nullable = false)
    private Integer totalPaymentPrice;

}
