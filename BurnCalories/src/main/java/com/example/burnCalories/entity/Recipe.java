package com.example.burnCalories.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String desc;
    int calories;
    int carbs;
    int fat;
    int protein;
    @ManyToOne
    User user;
}
