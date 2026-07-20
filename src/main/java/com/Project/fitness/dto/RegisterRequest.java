package com.Project.fitness.dto;


import com.Project.fitness.model.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "Email Required")
    @Email(message = "Invalid Email")
    private String email;

    @NotBlank(message = "Password Required")
    private String password;
    private String firstName;
    private String lastName;
    private UserRole role;
}
