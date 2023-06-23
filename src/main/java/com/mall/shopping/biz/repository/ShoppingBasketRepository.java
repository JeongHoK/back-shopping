package com.mall.shopping.biz.repository;

import com.mall.shopping.biz.entity.ShoppingBasket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingBasketRepository extends JpaRepository<ShoppingBasket, Long> {
}
