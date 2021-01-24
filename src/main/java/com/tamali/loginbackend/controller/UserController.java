package com.tamali.loginbackend.controller;

import com.tamali.loginbackend.model.User;
import com.tamali.loginbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();
        String tempPassword = user.getPassword();
        User userObj = null;

        if(tempEmail != null && tempPassword != null){
            userObj = userService.fetchUserByEmailAndPassword(tempEmail, tempPassword);

        }

        if(userObj == null){
            throw new Exception("Bad Credentials");
        }
        return userObj;
    }
}
