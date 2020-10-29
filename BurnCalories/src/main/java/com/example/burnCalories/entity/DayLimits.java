package com.example.burnCalories.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class DayLimits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer calories;
    Integer carbs;
    Integer fat;
    Integer protein;

    @OneToOne
    User user;

}
