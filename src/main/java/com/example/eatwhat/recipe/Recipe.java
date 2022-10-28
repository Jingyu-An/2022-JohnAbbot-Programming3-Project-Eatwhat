package com.example.eatwhat.recipe;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "eatwhat_recipe")
public class Recipe {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long recipeId;
  private String recipeTitle;
  private String recipeDescription;
  private Date recipeDate;
  private long point;
  
  public long getRecipeId() {
    return recipeId;
  }
  
  public void setRecipeId(long recipeId) {
    this.recipeId = recipeId;
  }
  
  public String getRecipeTitle() {
    return recipeTitle;
  }
  
  public void setRecipeTitle(String recipeTitle) {
    this.recipeTitle = recipeTitle;
  }
  
  public String getRecipeDescription() {
    return recipeDescription;
  }
  
  public void setRecipeDescription(String recipeDescription) {
    this.recipeDescription = recipeDescription;
  }
  
  public Date getRecipeDate() {
    return recipeDate;
  }
  
  public void setRecipeDate(Date recipeDate) {
    this.recipeDate = recipeDate;
  }
  
  public long getPoint() {
    return point;
  }
  
  public void setPoint(long point) {
    this.point = point;
  }
}
