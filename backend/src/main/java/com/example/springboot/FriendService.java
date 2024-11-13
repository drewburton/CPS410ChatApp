package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendService {

    private final FriendRepository friendRepository;

    @Autowired
    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    public Friend addFriend(Friend friend) {
        return friendRepository.save(friend);
    }

    public List<Friend> getAllFriends() {
        return friendRepository.findByName(null);
    }

    public Optional<Friend> getFriendById(Long id) {
        return friendRepository.findById(id);
    }

    public void deleteFriend(Long id) {
        friendRepository.deleteById(id);
    }

    public boolean removeFriend(Friend friend) {
        Optional<Friend> existingFriend = friendRepository.findById(friend.getId());
        if (existingFriend.isPresent()) {
            friendRepository.delete(existingFriend.get());
            return true;
        } else {
            return false; // Friend not found
        }
    }
}
