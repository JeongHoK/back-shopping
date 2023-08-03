package com.mall.shopping;

import com.mall.shopping.domain.product.entity.Product;
import com.mall.shopping.domain.product.entity.ProductCategory;
import com.mall.shopping.domain.user.entity.User;
import com.mall.shopping.domain.product.repo.ProductCategoryRepository;
import com.mall.shopping.domain.product.repo.ProductRepository;
import com.mall.shopping.domain.user.repo.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
class ShoppingApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    @Test
    void contextLoads() {
    }

    @Test
    void user_join() {

        User user = userRepository.save(User.builder().account_id("hello1").address("주소1").addressDetails("상세주소1").zipcode("12345").email("email@email.com1").phoneNumber("010-1234-5678").password("password").name("이름").build());

        User findUser = userRepository.findById(user.getId()).get();
        Assertions.assertThat(findUser.getId()).isEqualTo(user.getId());

    }

    @Test
    @Rollback(value = false)
    void initProduct() {

        ProductCategory category1 = ProductCategory.create("category1");
        ProductCategory category2 = ProductCategory.create("category2");
        ProductCategory category3 = ProductCategory.create("category3");

        productCategoryRepository.save(category1);
        productCategoryRepository.save(category2);
        productCategoryRepository.save(category3);

        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {

            Product product = null;

            if (i % 3 == 0) {
                product = Product.create(category1, "name" + i, i, i, "ex" + i);
            } else if (i % 3 == 1) {
                product = Product.create(category2, "name" + i, i, i, "ex" + i);
            } else if (i % 3 == 2) {
                product = Product.create(category3, "name" + i, i, i, "ex" + i);
            } else {
                throw new RuntimeException("here not in");
            }

            productList.add(product);
        }

        productRepository.saveAll(productList);

        Assertions.assertThat(productRepository.count()).isEqualTo(3000);
    }

}
