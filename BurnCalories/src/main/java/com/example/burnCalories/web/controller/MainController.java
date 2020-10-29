package com.example.burnCalories.web.controller;

import com.example.burnCalories.entity.DayLimits;
import com.example.burnCalories.entity.User;
import com.example.burnCalories.service.DayLimitsService;
import com.example.burnCalories.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class MainController {
    UserService userService;
    DayLimitsService dayLimitsService;

    public MainController(UserService userService, DayLimitsService dayLimitsService) {
        this.userService = userService;
        this.dayLimitsService = dayLimitsService;
    }

    @GetMapping("/")
    String homepage(){
        return "homepage";
    }
    @GetMapping("/calculate")
    String calculate(){
        return "calculate";
    }
    @PostMapping("/calculate")
    String calculateImpl(Principal principal, @RequestParam String gender,
                         @RequestParam int age, @RequestParam int weight,
                         @RequestParam String activityLevel,@RequestParam int  high){
        User user = userService.findUserByEmail(principal.getName());
        DayLimits dayLimits = dayLimitsService.findByUserId(user.getId());
        DayLimits readDayLimits;
        double calories;
        if(dayLimits==null) {
            readDayLimits = new DayLimits();
            calculate(gender, age, weight, activityLevel, high, readDayLimits);
            readDayLimits.setUser(user);
            DayLimits actualDayLimits = dayLimitsService.save(readDayLimits);
            user.setDayLimits(actualDayLimits);
            userService.save(user);
        } else {
            readDayLimits = dayLimits;
            calculate(gender, age, weight, activityLevel, high, readDayLimits);
            dayLimitsService.save(readDayLimits);
        }
        return "redirect:/";
    }

    private void calculate(String gender, int age, int weight, String activityLevel, int high, DayLimits readDayLimits) {
        double calories;
        if(gender.equals("M")) {
            calories = (88 + (13.4 * weight) + (4.8 * high)) - (5.7 * age);
        } else{
            calories = (448 + (9.2 * weight) + (3.1 * high)) - (4.2 * age);
        }
        switch (activityLevel){
            case "min":
                calories*=1.2;
                break;
            case "low":
                calories*=1.375;
                break;
            case "mid":
                calories*=1.55;
                break;
            case "upmid":
                calories*=1.725;
                break;
            case "high":
                calories*=1.9;
                break;
        }
        readDayLimits.setCalories((int) calories);
        double carbs = calories*0.3/4;
        double fat = calories*0.3/9;
        double protein =calories*0.3/4;
        readDayLimits.setCarbs((int) carbs);
        readDayLimits.setFat((int) fat);
        readDayLimits.setProtein((int) protein);
    }

    @ModelAttribute
    public void addUser(Model model, Principal principal){
        User user = userService.findUserByEmail(principal.getName());
        model.addAttribute("user", user);
    }
}
