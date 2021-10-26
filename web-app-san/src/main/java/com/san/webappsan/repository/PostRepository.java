package com.san.webappsan.repository;

import org.springframework.stereotype.Repository;

import com.san.webappsan.domain.Post;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
