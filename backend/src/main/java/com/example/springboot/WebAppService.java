package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebAppService {
    @Autowired
    private MessageRepository messageRepository;

    public List<MessageRequest> getChats() {
        return null;
//        return messageRepository.findAll();
    }
}
