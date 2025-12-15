package com.bus.user.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class UserResponse {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String role;
    private String keycloakUserId;
    private Instant createdAt;
    private Instant updatedAt;
}
