package com.example.eatwhat.dao;

import com.example.eatwhat.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("SELECT r FROM Recipe r, User u WHERE r.user.id = u.id AND u.id =? 1")
    List<Recipe> findAllByUser(long id);
}
