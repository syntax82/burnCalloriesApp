package com.example.burnCalories.service;

import com.example.burnCalories.entity.Recipe;
import com.example.burnCalories.entity.User;
import com.example.burnCalories.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class RecipeServiceImpl implements RecipeService {

    RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> findAllByUser(User user) {

        return recipeRepository.findAllByUser(user);
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public Recipe findRecipeById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }
}
