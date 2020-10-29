package com.example.burnCalories.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {
    String name;
    String lastName;
    String email;
    String password;
}
