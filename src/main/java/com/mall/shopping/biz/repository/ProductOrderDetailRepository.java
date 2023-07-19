package com.mall.shopping.biz.repository;

import com.mall.shopping.biz.domain.ProductOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderDetailRepository extends JpaRepository<ProductOrderDetail, Long> {
}
