package com.example.eatwhat.dao;

import com.example.eatwhat.model.Recipe;
import com.example.eatwhat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

//    @Query("SELECT r FROM Recipe r WHERE r.user = ?user")
    List<Recipe> findAllByUser(User user);
}
