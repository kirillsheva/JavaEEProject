package com.example.demo.service;

import com.example.demo.repo.NoticeRepo;
import com.example.demo.repo.ProductRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.requesBodies.CategoryRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderServiceTest {
    @Autowired
    UserRepo userRepo;

    @Autowired
    OrderService orderService;

    @Test
    void getAlltheProducts() {
        orderService.getAlltheProducts("Johnson");
        assertThat(userRepo.existsById("Johnson"));
    }
}