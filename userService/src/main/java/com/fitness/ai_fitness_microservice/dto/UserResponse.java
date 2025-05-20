package com.fitness.ai_fitness_microservice.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data //it is used to generate getters and setters
public class UserResponse {

    private String Id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
