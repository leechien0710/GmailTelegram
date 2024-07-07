package com.example.springmail.service;

import com.example.springmail.common.HttpRes;
import com.example.springmail.dto.SaveUserDto;
import com.example.springmail.dto.respone.SaveUserRes;
import com.example.springmail.entity.User;
import com.example.springmail.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public SaveUserRes saveUser(SaveUserDto  saveUserDto) {
        User user = new User();
        user.setName(saveUserDto.getName());
        user.setId(saveUserDto.getId());
        try {
            userRepository.save(user);
        }
        catch (Exception e) {
            return new SaveUserRes(new HttpRes("400", "Save User Error"));
        }
        return new SaveUserRes(new HttpRes("200", "Success"));
    }
}
