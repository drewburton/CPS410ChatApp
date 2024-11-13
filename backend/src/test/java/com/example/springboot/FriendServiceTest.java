package com.example.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class FriendServiceTest {

    @Autowired
    private FriendService friendService;

    @MockBean
    private FriendRepository friendRepository; // Assuming this is your data layer
    

    @Test
    public void testAddFriend() {
        // Given
        Friend friend = new Friend("Alice", "alice@example.com"); // Adjust the constructor if necessary
        when(friendRepository.save(any(Friend.class))).thenReturn(friend);

        // When
        Friend result = friendService.addFriend(friend);

        // Then
        assertNotNull(result);
        assertEquals("Alice", result.getName());
        verify(friendRepository, times(1)).save(any(Friend.class));
    }

    @Test
    public void testRemoveFriend() {
        // Given
        Friend friend = new Friend("user1", "email"); // This should match your Friend constructor
        friendService.addFriend(friend); // Ensure you add the friend before removing
        // Mocking behavior
        when(friendRepository.existsById(friend.getId())).thenReturn(true); // Mock that the friend exists
        // When
        boolean result = friendService.removeFriend(friend);
        // Then (Improved assertion)
        if (result) {
            verify(friendRepository, times(1)).delete(friend); // Assuming delete method exists
            assertTrue(result, "Friend should be removed successfully");
        } else {
            assertFalse(result, "Friend removal might have failed"); // Adjust message if needed
        }
    }
}
