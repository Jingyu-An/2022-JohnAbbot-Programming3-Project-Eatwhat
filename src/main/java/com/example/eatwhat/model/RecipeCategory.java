package com.example.eatwhat.model;

import javax.persistence.*;

@Entity
@Table(name = "eatwhat_recipe_category")
public class RecipeCategory {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long recipeCategoryId;
  private String catDescription;
  
  public long getRecipeCategoryId() {
    return recipeCategoryId;
  }
  
  public void setRecipeCategoryId(long recipeCategoryId) {
    this.recipeCategoryId = recipeCategoryId;
  }
  
  public String getCatDescription() {
    return catDescription;
  }
  
  public void setCatDescription(String catDescription) {
    this.catDescription = catDescription;
  }
}
