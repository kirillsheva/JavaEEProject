package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.requesBodies.CategoryRequest;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.verify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class CategoryServiceTest {
    @Autowired
    private CategoryService catService;
    @Autowired
    private CategoryRepo catRepo;
    @Test
    void addCategory() {
        catService.addCategory(
                CategoryRequest.builder()
                        .cid("1234")
                        .cname("Headphones")
                        .build()
        );
        assertThat(catRepo.existsById("1234"));

    }

    @Test
    void removeCategory() {
        catService.addCategory(
                CategoryRequest.builder()
                        .cid("1000")
                        .cname("Headphones")
                        .build()
        );
        catService.removeCategory("Headphones");
        assertThat(catRepo.existsById("1000"));

    }
}