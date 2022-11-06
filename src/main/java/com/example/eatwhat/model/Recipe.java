package com.example.eatwhat.model;

import jdk.jfr.Name;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "eatwhat_recipe")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Name("recipe_id")
    private long id;


    private String recipeTitle;


    private String recipeDescription;

    private int recipePoint;

    private String cookingTime;
    
    @Column(nullable = true)
    private String photos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category_id")
    public RecipeCategory recipeCategory;


    @Transient
    public String getPhotosImagePath() {
        if (photos == null || id == 0) return null;

        return "/recipe-photos/" + id + "/" + photos;
    }

}
