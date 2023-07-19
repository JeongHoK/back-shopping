package com.mall.shopping.biz.repository;

import com.mall.shopping.biz.domain.ProductPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPaymentRepository extends JpaRepository<ProductPayment, Long> {
}
