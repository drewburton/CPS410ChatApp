package com.example.springboot;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository {

    Friend save(Friend friend);

    List<Friend> findByName(String name);

    Optional<Friend> findById(Long id);

    void deleteById(Long id);

    void delete(Friend friend);

    boolean existsById(Long id);
}
