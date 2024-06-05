package com.techindeck.cms.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.techindeck.cms.models.PostModel;

public interface PostRepository extends MongoRepository<PostModel, String>{

    // join post userId with user id
    List<PostModel> findByUserId(String userId);

    
}
