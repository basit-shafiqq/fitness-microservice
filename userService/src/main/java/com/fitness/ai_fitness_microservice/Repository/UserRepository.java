package com.fitness.ai_fitness_microservice.Repository;

import com.fitness.ai_fitness_microservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByEmail(String email);
}
