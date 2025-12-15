package com.bus.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {
    @NotBlank
    private String name;

    @Email
    private String email;

    private String phone;

    // default role when creating a user
    private String role = "USER";
}
