package com.example.burnCalories.web.controller;

import com.example.burnCalories.service.UserService;
import com.example.burnCalories.web.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    String getRegistrationPage(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto",userDto);
        return "registration";
    }
    @PostMapping("/registration")
    String registration(@ModelAttribute UserDto userDto){
        userService.save(userDto);
        return "redirect:/login";
    }
}
