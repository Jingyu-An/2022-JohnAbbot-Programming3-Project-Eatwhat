package com.example.eatwhat.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "eatwhat_recipe")
@Data
public class Recipe {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long recipeId;
  private String recipeTitle;
  private String recipeDescription;
  private Date recipeDate;
  private long point;

}
