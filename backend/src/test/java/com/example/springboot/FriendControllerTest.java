package com.example.springboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class FriendControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FriendService friendService;

    private Friend testFriend;

    @BeforeEach
    public void setup() {
        testFriend = new Friend("Alice", "alice@example.com");
    }

    @Test
    public void testAddFriend() throws Exception {
        when(friendService.addFriend(any(Friend.class))).thenReturn(testFriend);

        mockMvc.perform(post("/api/friends")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Alice\", \"email\": \"alice@example.com\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Alice"))
                .andExpect(jsonPath("$.email").value("alice@example.com"));

        verify(friendService, times(1)).addFriend(any(Friend.class));
    }

    @Test
    public void testGetAllFriends() throws Exception {
        when(friendService.getAllFriends()).thenReturn(List.of(testFriend));

        mockMvc.perform(get("/api/friends"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value("Alice"));

        verify(friendService, times(1)).getAllFriends();
    }

    @Test
    public void testDeleteFriend() throws Exception {
        doNothing().when(friendService).deleteFriend(anyLong());

        mockMvc.perform(delete("/api/friends/1"))
                .andExpect(status().isNoContent());

        verify(friendService, times(1)).deleteFriend(anyLong());
    }
}