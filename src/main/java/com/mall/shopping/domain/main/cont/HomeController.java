package com.mall.shopping.domain.main.cont;

import com.mall.shopping.domain.product.dto.ProductDto;
import com.mall.shopping.domain.product.repo.ProductQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final ProductQueryRepository productQueryRepository;

    // 전체 상품을 쓸 곳이 있는가?
    @GetMapping("/api/products")
    List<ProductDto> products() {
        return productQueryRepository.getProductDtos();
    }

    // 카테고리 상품 > 카테고리 눌러서 들어갔을 때 뜨는 거 sort 기준이 필요하겠죠? 판매량 순, 평점 순
    @GetMapping("/api/products/{id}/{sort}")
    Page<ProductDto> products(@PathVariable("id") Long productCategoryId, @PathVariable("sort") String sort, Pageable pageable) {
        return productQueryRepository.getProductDtos(productCategoryId, sort, pageable);
    }

    // 카테고리별 Top 5 (판매량 순 or 평점 순으로 고를 수 있어야 함)
}
