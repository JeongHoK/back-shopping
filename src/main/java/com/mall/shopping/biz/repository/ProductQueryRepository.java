package com.mall.shopping.biz.repository;

import com.mall.shopping.biz.dto.ProductDto;
import com.querydsl.core.types.NullExpression;
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
import java.util.Objects;

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

        // FIXME : 이렇게 하면 NULL 기준으로 sort 나간다.
        //  - 조건 없을 땐 아예 빼고 싶은데..

        OrderSpecifier orderSpecifier = new OrderSpecifier(Order.ASC, NullExpression.DEFAULT);

        if(StringUtils.hasText(sort) && sort.equals("star-score")) {
            orderSpecifier = new OrderSpecifier(Order.DESC, product.starScore);
        }

        return orderSpecifier;
    }
}
