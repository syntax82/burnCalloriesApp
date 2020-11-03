package com.example.burnCalories.repository;


import com.example.burnCalories.entity.Recipe;
import com.example.burnCalories.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("select r from Recipe r where r.user =:user")
    List<Recipe> findAllByUser(User user);
}
