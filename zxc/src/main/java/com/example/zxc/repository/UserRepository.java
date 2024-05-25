package com.example.zxc.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.example.zxc.models.User;

import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Integer> {
    
    Mono<User> findByUsernameAndPassword(String Username, String Password);
}
