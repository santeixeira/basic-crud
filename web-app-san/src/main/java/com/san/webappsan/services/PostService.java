package com.san.webappsan.services;

import java.util.List;
import java.util.Optional;

import com.san.webappsan.domain.Post;
import com.san.webappsan.repository.PostRepository;
import com.san.webappsan.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;
    
    public Post findById(String id) {
        Optional<Post> obj= repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }


}
