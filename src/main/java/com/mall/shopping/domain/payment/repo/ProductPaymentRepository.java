package com.mall.shopping.domain.payment.repo;

import com.mall.shopping.domain.payment.entity.ProductPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPaymentRepository extends JpaRepository<ProductPayment, Long> {
}
