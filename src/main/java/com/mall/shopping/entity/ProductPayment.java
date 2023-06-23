package com.mall.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ProductPayment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productOrderId")
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
