package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private FriendService friendService;

    @MockBean
    private FriendRepository friendRepository;

    @Test
    void contextLoads() {
        assert(friendService != null);
        assert(friendRepository != null);
    }
	
}
