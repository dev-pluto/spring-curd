package com.techindeck.cms.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.techindeck.cms.models.UserModel;

public interface UserInterface extends MongoRepository<UserModel, String>{

}
