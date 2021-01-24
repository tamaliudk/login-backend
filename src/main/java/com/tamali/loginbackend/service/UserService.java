package com.tamali.loginbackend.service;

import com.tamali.loginbackend.model.User;
import com.tamali.loginbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User fetchUserByEmailAndPassword(String email, String password) {
        return repo.findByEmailAndPassword(email, password);
    }
}