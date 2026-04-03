package com.example.architecture.service;

import com.example.architecture.dto.UserCreatedEvent;
import com.example.architecture.dto.UserDTO;
import com.example.architecture.entity.User;
import com.example.architecture.exception.UserWithUsernameAlreadyExist;
import com.example.architecture.mapper.UserDTOMapper;
import com.example.architecture.repository.UserRepository;
import com.example.architecture.service.cache.UserCacheService;
import com.example.architecture.service.publisher.UserEventPublisher;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class UserService {

    UserRepository userRepository;
    UserCacheService userCacheService;
    UserDTOMapper mapper;
    UserEventPublisher userEventPublisher;

    public int createUser(String userName) {
        if (userRepository.findByName(userName).isPresent()) {
            throw new UserWithUsernameAlreadyExist("user with this username already exist");
        }
        User user = User
                .builder()
                .name(userName)
                .build();

        userRepository.save(user);

        UserCreatedEvent userCreatedEvent = new UserCreatedEvent(user.getId(), user.getName());
        userEventPublisher.publishUserEvent(userCreatedEvent);

        return user.getId();
    }

    public UserDTO getById(int id) {
        Optional<UserDTO> cachedUser = userCacheService.getFromCache(id);

        // cache hit - нашел пользователя в кэше
        //noinspection OptionalIsPresent
        if (cachedUser.isPresent()) {
            log.info("User cache hit");
            System.out.println("User cache hit");
            return cachedUser.get();
        }

        log.info("User cache miss");
        System.out.println("User cache miss");
        UserDTO userFromDB = mapper.toDto(userRepository.findById(id));

        userCacheService.saveToCache(userFromDB);
        return userFromDB;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);

        log.info("User cache evict on delete");
        userCacheService.removeFromCache(id);
    }
}
