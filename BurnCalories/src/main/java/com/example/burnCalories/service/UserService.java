package com.example.burnCalories.service;

import com.example.burnCalories.entity.User;
import com.example.burnCalories.web.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService  {
    User save(UserDto userDto);
    User findUserByEmail(String email);
    User save(User user);
}
