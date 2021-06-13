package com.example.demo.service;

import com.example.demo.repo.ProductRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.requesBodies.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProductServiceImpl productService ;
    @Autowired
    ProductRepo productRepo;
    @Test
    void addProduct() {
        productService.addProduct(
                ProductRequest.builder()
                      .pcategory("Watches")
                        .pdescription("Aaalalal")
                        .pdiscount(2)
                        .pname("Rolex gold")
                        .powner("Admin")
                        .pprice(12122)

                        .build()
        );
        assertThat(productRepo.existsById("Watches"));

    }

    @Test
    void updateProduct() {
        productService.updateProduct(
                ProductUpdateRequest.builder()
                        .pcategory("Watches")
                        .pdescription("Aaalalal")
                        .pdiscount(2)
                        .pname("Rolex gold")
                        .id("12312")
                        .pprice(12122)

                        .build()
        );
        assertThat(productRepo.existsById("12312"));
    }

    @Test
    void addComment() {
        productService.addComment(
                CommentReq.builder()
                  .comment("asda")
                        .productid("1")
                        .username("Jackson")
                        .build()
        );
        assertThat(productRepo.existsById("12312"));
    }

    @Test
    void addRating() {
        productService.addRating(
                RatingReq.builder()
                .productid("1")
                        .rating(4)

                        .build()
        );
        assertThat(productRepo.existsById("1"));
    }

    @Test
    void removeProduct() {
        productService.addProduct(
                ProductRequest.builder()
                        .pcategory("Watches")
                        .pdescription("Aaalalal")
                        .pdiscount(2)
                        .pname("Rolex gold")
                        .powner("Admin")
                        .pprice(12122)

                        .build()
        );
        productService.removeProduct("1");
    }

    @Test
    void searchProducts() {
        productService.searchProducts("Iphone");
    }
}