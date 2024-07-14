package com.portal.portal.usuario.controller;

import com.portal.portal.usuario.entity.User;
import com.portal.portal.usuario.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/User")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveuser(@RequestBody User user){
        return userService.saveUser(user);
    }

}