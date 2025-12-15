package com.bus.user.controller;

import com.bus.user.dto.UserRequest;
import com.bus.user.dto.UserResponse;
import com.bus.user.model.User;
import com.bus.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "User API", description = "User management endpoints")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest request) {
        User u = userService.createUser(request);
        return new ResponseEntity<>(toResponse(u), HttpStatus.CREATED);
    }

    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAllUsers().stream().map(this::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable String id) {
        User u = userService.getUser(id);
        return ResponseEntity.ok(toResponse(u));
    }

    private UserResponse toResponse(User u) {
        return UserResponse.builder()
                .id(u.getId())
                .name(u.getName())
                .email(u.getEmail())
                .phone(u.getPhone())
                .role(u.getRole())
                .keycloakUserId(u.getKeycloakUserId())
                .createdAt(u.getCreatedAt())
                .updatedAt(u.getUpdatedAt())
                .build();
    }
}
