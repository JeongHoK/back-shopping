package com.mall.shopping.domain.product.repo;

import com.mall.shopping.domain.product.dto.ProductDto;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.mall.shopping.biz.entity.QProduct.product;

@Transactional(readOnly = true)
@Repository
@RequiredArgsConstructor
public class ProductQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<ProductDto> getProductDtos() {
        return queryFactory.select(Projections.constructor(ProductDto.class, product))
                .from(product)
                .fetch();
    }

    public Page<ProductDto> getProductDtos(Long productCategoryId, String sort, Pageable pageable) {

        List<ProductDto> content = queryFactory.select(Projections.constructor(ProductDto.class, product))
                .from(product)
                .where(product.productCategory.id.eq(productCategoryId))
                .orderBy(createOrderSpecifier(sort))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(content, pageable, content.size());
    }

    private OrderSpecifier createOrderSpecifier(String sort) {

        // TODO : 뭔가 깔끔하지는 않은 느낌인데..
        //  - sort의 값이 없을 때 여기 들어오지 않고 querydsl에서 걸러지게 할 수 있는 방법이 있을까?
        if(!StringUtils.hasText(sort)) {
           return new OrderSpecifier(Order.DESC, product.id);
        } else if (sort.equals("star-score")) {
            return new OrderSpecifier(Order.DESC, product.starScore);
        } else {
            return new OrderSpecifier(Order.DESC, product.id);
        }
    }
}
