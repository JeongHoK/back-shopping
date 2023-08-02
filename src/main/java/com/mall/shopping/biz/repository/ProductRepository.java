package com.mall.shopping.biz.repository;

import com.mall.shopping.biz.dto.ProductDto;
import com.mall.shopping.biz.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
