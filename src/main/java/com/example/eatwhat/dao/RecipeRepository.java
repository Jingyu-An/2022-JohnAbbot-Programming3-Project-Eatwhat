package com.example.eatwhat.dao;

import com.example.eatwhat.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("select r from Recipe r, User u where r.id =u.id")
    List<Recipe> findAllByRecipeIn(long userId);



}
