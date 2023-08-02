package com.mall.shopping.biz.repository;

import com.mall.shopping.biz.dto.ProductDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProductQueryRepositoryTest {

    @Autowired
    private ProductQueryRepository productQueryRepository;

    @Test
    void getProductDtos() {
        List<ProductDto> productDtos = productQueryRepository.getProductDtos();

        Assertions.assertThat(productDtos.size()).isEqualTo(3000);
    }

    @Test
    void testGetProductDtos() {

        Page<ProductDto> productDtos = productQueryRepository.getProductDtos(1L, "star-score", PageRequest.of(0, 10));

        Assertions.assertThat(productDtos.getSize()).isEqualTo(10);

        for (ProductDto productDto : productDtos) {
            System.out.println("productDto = " + productDto.toString());
        }
    }
}