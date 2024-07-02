package com.example.springmail.controller;

import com.example.springmail.dto.SaveUserDto;
import com.example.springmail.dto.respone.SaveUserRes;
import com.example.springmail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/save")
    public ResponseEntity<SaveUserRes> save(SaveUserDto saveUserDto) {
        return ResponseEntity.ok(userService.saveUser(saveUserDto));
    }

}
