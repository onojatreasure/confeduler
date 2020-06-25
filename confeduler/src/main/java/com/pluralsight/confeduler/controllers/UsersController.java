package com.pluralsight.confeduler.controllers;

import com.pluralsight.confeduler.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    @Autowired
    private UserRepository userRepository;

  
    
}
