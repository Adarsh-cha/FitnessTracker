package com.Project.fitness.service;

import com.Project.fitness.dto.RegisterRequest;
import com.Project.fitness.dto.UserResponse;
import com.Project.fitness.model.User;
import com.Project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse register(RegisterRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(request.getPassword())
                .build();

        User savedUser = userRepository.save(user);
        return mappedUserResponse(savedUser);
    }

    private UserResponse mappedUserResponse(User user) {
        return  UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .createdAt(user.getCreatedAt())
                .updateAt(user.getUpdateAt())
                .build();
    }
}
