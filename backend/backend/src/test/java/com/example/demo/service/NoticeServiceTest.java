package com.example.demo.service;

import com.example.demo.repo.NoticeRepo;
import com.example.demo.requesBodies.CategoryRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.not;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NoticeServiceTest {
    @Autowired
    NoticeRepo noticeRepo;
    @Autowired
    NoticeService noticeService;
    @Test
    void addNotice() {
        noticeService.addNotice("iphones","Hello dear fans");
        assertThat(noticeRepo.findById("iphones"));
    }

    @Test
    void getallNotices() {
        noticeService.getallNotices();
        assertThat(noticeService.getallNotices().equals(noticeRepo.findAll()));
    }
}