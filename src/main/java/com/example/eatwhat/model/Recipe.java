package com.example.eatwhat.model;

import jdk.jfr.Name;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "eatwhat_recipe")
@Data
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Name("recipe_id")
    private long id;

    private String recipeTitle;

    private String recipeDescription;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date recipeDate;

    private int point;

    @OneToOne
    private User user;

    private long recipeCategoryId;


}
