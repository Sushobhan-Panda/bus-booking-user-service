package com.bus.user.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;

    private String name;
    private String email;
    private String phone;
    private String role; // USER, ADMIN, OPERATOR
    private String keycloakUserId; // filled later when integrated

    private Instant createdAt;
    private Instant updatedAt;
}
