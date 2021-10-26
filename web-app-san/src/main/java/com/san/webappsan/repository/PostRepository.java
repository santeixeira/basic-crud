package com.san.webappsan.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.san.webappsan.domain.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query ("{'title':{$regex:?0, $options:'i'}}")
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);
}
