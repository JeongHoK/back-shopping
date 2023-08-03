package com.mall.shopping.domain.user.repo;

import com.mall.shopping.domain.user.entity.ShoppingBasket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingBasketRepository extends JpaRepository<ShoppingBasket, Long> {
}
