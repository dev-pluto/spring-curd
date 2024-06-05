package com.techindeck.cms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techindeck.cms.models.UserModel;
import com.techindeck.cms.repositories.UserInterface;

@Service
public class UserService {

    @Autowired
    private UserInterface userInterface;

//    get all users
    public List<UserModel> getAllUsers() {
        return userInterface.findAll();
    }

    // get user by id
    public Optional<UserModel> getUserById(String id) {
        return userInterface.findById(id);
    }

    // save user
    public UserModel saveUser(UserModel user) {
        return userInterface.save(user);
    }

    // delete user
    public void deleteUser(String id) {
        userInterface.deleteById(id);
    }

    // update user
    public UserModel updateUser(String id, UserModel user) {
        Optional<UserModel> userOptional = userInterface.findById(id);
        if (userOptional.isPresent()) {
            UserModel details = userOptional.get();
            details.setName(user.getName());
            details.setEmail(user.getEmail());
            return userInterface.save(user);
        } else {
            return null;
        }
    }

}
