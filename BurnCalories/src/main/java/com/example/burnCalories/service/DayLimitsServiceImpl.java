package com.example.burnCalories.service;

import com.example.burnCalories.entity.DayLimits;
import com.example.burnCalories.repository.DayLimitsRepository;
import org.springframework.stereotype.Service;

@Service
public class DayLimitsServiceImpl implements DayLimitsService{
    DayLimitsRepository dayLimitsRepository;

    public DayLimitsServiceImpl(DayLimitsRepository dayLimitsRepository) {
        this.dayLimitsRepository = dayLimitsRepository;
    }

    @Override
    public DayLimits save(DayLimits dayLimits) {
        return dayLimitsRepository.save(dayLimits);
    }

    @Override
    public DayLimits findByUserId(Long id) {
        return dayLimitsRepository.findFirstByUserId(id);
    }
}
