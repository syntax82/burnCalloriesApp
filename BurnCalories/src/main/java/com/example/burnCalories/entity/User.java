package com.example.burnCalories.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String lastName;
    @Column(unique = true)
    String email;
    String password;
    @ManyToMany(fetch = FetchType.EAGER)
    List<Role> roles = new ArrayList<>();
    @OneToOne
    DayLimits dayLimits;
    @OneToMany(mappedBy = "user")
    List<Recipe> recipes = new ArrayList<>();
}
