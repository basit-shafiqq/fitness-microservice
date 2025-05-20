package com.fitness.ai_fitness_microservice.controller;

import com.fitness.ai_fitness_microservice.dto.RegisterRequest;
import com.fitness.ai_fitness_microservice.dto.UserResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fitness.ai_fitness_microservice.service.UserService;

@RestController
@RequestMapping("/api/users")
//@AllArgsConstructor // similar to autowired from lombok
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserProfile(@PathVariable String userId){

        return ResponseEntity.ok(userService.getUserProfile(userId));
    }


    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest request){

        return ResponseEntity.ok(userService.register(request));
    }

    @GetMapping("/{userId}/validate")
    public ResponseEntity<Boolean> validateUser(@PathVariable String userId){

        return ResponseEntity.ok(userService.existByUserId(userId));
    }

}

