package com.example.architecture.service;

import com.example.architecture.entity.User;
import com.example.architecture.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserService {

    UserRepository userRepository;

    public int createUser(String userName) {
        User user = User
                .builder()
                .name(userName)
                .build();
        userRepository.save(user);
        return user.getId();
    }

    public User getById(int id) {
        return userRepository.findById(id);
    }
}
