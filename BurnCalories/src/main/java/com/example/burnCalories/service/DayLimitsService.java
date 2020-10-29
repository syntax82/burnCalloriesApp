package com.example.burnCalories.service;

import com.example.burnCalories.entity.DayLimits;
import com.example.burnCalories.entity.User;

public interface DayLimitsService {
    DayLimits save(DayLimits dayLimits);
    DayLimits findByUserId(Long id);
}
