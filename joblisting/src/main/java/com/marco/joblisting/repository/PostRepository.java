package com.marco.joblisting.repository;

import com.marco.joblisting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}
