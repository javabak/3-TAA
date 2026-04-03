package com.example.architecture.mapper;

import com.example.architecture.dto.UserDTO;
import com.example.architecture.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserDTOMapper {

    public User toUser(UserDTO userDTO) {
        return User
                .builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .build();
    }

    public UserDTO toDto(User user) {
        return UserDTO
                .builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }
}
