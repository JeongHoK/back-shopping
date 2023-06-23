package com.mall.shopping.repository;

import com.mall.shopping.entity.ProductOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderDetailRepository extends JpaRepository<ProductOrderDetail, Long> {
}
