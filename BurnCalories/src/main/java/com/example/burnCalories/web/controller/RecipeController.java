package com.example.burnCalories.web.controller;

import com.example.burnCalories.entity.Recipe;
import com.example.burnCalories.entity.User;
import com.example.burnCalories.service.RecipeService;
import com.example.burnCalories.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    RecipeService recipeService;
    UserService userService;

    public RecipeController(RecipeService recipeService, UserService userService) {
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @GetMapping("")
    String getRecipes(Model model, Principal principal){
        User user = userService.findUserByEmail(principal.getName());
        List<Recipe> recipes = recipeService.findAllByUser(user);
        model.addAttribute("recipes", recipes);
        return "recipes";
    }

    @GetMapping("/add")
    String addRecipe(Model model){
        model.addAttribute("recipe", new Recipe());
        return "addRecipe";
    }


    @GetMapping("/edit/{id}")
    String editRecipe(Model model, @PathVariable Long id){
        Recipe recipe = recipeService.findRecipeById(id);
        model.addAttribute("recipe",recipe);
        return "editRecipe";
    }


    @GetMapping("/delete/{id}")
    String deleteRecipe(Model model, @PathVariable Long id){
        recipeService.deleteById(id);
        return "redirect:/recipes";
    }

    @PostMapping("/add")
    String addRecipeImpl(Recipe recipe, Principal principal){
        User user = userService.findUserByEmail(principal.getName());
        recipe.setUser(user);
        recipeService.save(recipe);
        return "redirect:/recipes";
    }
}
