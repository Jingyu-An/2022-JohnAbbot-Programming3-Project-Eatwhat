package com.example.eatwhat.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "eatwhat_recipe_category")
@Data
public class RecipeCategory {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long recipeCategoryId;
  private String catDescription;

}
