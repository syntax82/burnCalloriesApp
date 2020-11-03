package com.example.burnCalories.service;

import com.example.burnCalories.entity.Recipe;
import com.example.burnCalories.entity.User;

import java.util.List;

public interface RecipeService {
    List<Recipe> findAllByUser(User user);
    Recipe save(Recipe recipe);
    void deleteById(Long id);
    Recipe findRecipeById(Long id);

}
