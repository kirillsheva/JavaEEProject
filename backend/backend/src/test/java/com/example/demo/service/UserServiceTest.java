package com.example.demo.service;

import com.example.demo.repo.ProductRepo;
import com.example.demo.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepo userRepo;

    @Autowired
    ProductRepo productRepo;
    @Test
    void findUserByUsername() {
      assertThat(userService.findUserByUsername("Jackson"));
    }


    @Test
    void login() {
        userService.Login("Jackson","21oeiu12hb31");
        assertThat(userRepo.findByUsername("Jackson"));
    }

    @Test
    void removeFromCart() {
        userService.removeFromCart("Jackson",1);
    }

    @Test
    void addtoWishList() {
        userService.addtoWishList("Jackson","1");
    }

    @Test
    void changePassword() {
        userService.changePassword("Jackson","21oeiu12hb31","www");
    }

    @Test
    void removeUser() {
        userService.removeUser("Jackson");
        assertThat(userRepo.findByUsername("Jackson"));
    }
}