package com.san.webappsan.services;

import java.util.List;

import com.san.webappsan.domain.User;
import com.san.webappsan.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
    
}
