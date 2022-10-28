package com.example.eatwhat.model;

import jdk.jfr.Name;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "eatwhat_recipe_category")
@Data
@NoArgsConstructor
public class RecipeCategory {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Name("category_id")
  private long id;

  private String catDescription;

}
