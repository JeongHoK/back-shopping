package com.mall.shopping.repository;

import com.mall.shopping.entity.ProductPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPaymentRepository extends JpaRepository<ProductPayment, Long> {
}
