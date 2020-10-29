package com.example.burnCalories.repository;

import com.example.burnCalories.entity.DayLimits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayLimitsRepository extends JpaRepository<DayLimits,Long> {
    DayLimits findFirstByUserId(Long id);
}
