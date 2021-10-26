package com.san.webappsan.repository;

import org.springframework.stereotype.Repository;

import com.san.webappsan.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
}
