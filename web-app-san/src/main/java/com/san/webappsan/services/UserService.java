package com.san.webappsan.services;

import java.util.List;
import java.util.Optional;

import com.san.webappsan.domain.User;
import com.san.webappsan.dto.UserDTO;
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

    public User insert(User obj) {
        return repo.insert(obj); 
    }

    public void delete(String id) {
        //After Spring boot 2. , all delete has to call ByObj, in that case, I'm using Id
        findById(id);
        repo.deleteById(id);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }


}
