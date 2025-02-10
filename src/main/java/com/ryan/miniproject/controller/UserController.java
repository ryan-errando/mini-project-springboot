package com.ryan.miniproject.controller;

import com.ryan.miniproject.model.User;
import com.ryan.miniproject.service.EmailService;
import com.ryan.miniproject.service.UserService;
import com.ryan.miniproject.service.WebHookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private WebHookService webHookService;

    @Autowired
    private EmailService emailService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveUser(@RequestBody User user){
        webHookService.sendData(user);
        service.saveUser(user);
        emailService.sendEmail("errandoryan@gmail.com", "Welcome " + user.getFullName() + "!", "thank you for registering to our website!");
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        return ResponseEntity.ok(service.findAllUser());
    }

}
