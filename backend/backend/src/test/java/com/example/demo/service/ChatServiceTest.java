package com.example.demo.service;

import com.example.demo.model.Message;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.repo.ChatRepo;
import com.example.demo.requesBodies.CategoryRequest;
import com.example.demo.requesBodies.ChatRequst;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ChatServiceTest {
    @Autowired
    private ChatService chatService;
    @Autowired
    private ChatRepo chatRepo;


    @Test
    void addMessage() {
        chatService.addMessage("A","AAA");
        assertThat(chatRepo.findById("A"));
    }
}