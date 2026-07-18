package com.Project.fitness.service;

import com.Project.fitness.dto.RegisterRequest;
import com.Project.fitness.dto.UserResponse;
import com.Project.fitness.model.User;
import com.Project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse register(RegisterRequest request) {
        User user = new User(null, request.getEmail(), request.getPassword(), request.getFirstName(), request.getLastName(), Instant.parse("2026-07-18T06:17:34.334Z").atZone(ZoneOffset.UTC).toLocalDate(),Instant.parse("2026-07-18T06:17:34.334Z").atZone(ZoneOffset.UTC).toLocalDate(), List.of(), List.of());

        User savedUser = userRepository.save(user);
        return mappedUserResponse(user);
    }

    private UserResponse mappedUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdateAt(user.getUpdateAt());
        return userResponse;
    }
}
