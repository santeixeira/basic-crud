package com.san.webappsan.services;

import java.util.List;
import java.util.Optional;

import com.san.webappsan.domain.User;
import com.san.webappsan.repository.UserRepository;
import com.san.webappsan.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    
    public List<User> findAll() {
        return repo.findAll();
    }
    
    public User findById(String id) {
        Optional<User> obj= repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }



}
