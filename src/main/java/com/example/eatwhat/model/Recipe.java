package com.example.eatwhat.model;

import jdk.jfr.Name;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @NotBlank(message = "Must be not empty")
    @Size(min = 5, max = 30, message = "Title between 5 to 30 characters")
    private String recipeTitle;

    private String recipeDescription;

    private int recipePoint;

    @NotBlank(message = "Must be not empty")
    private String cookingTime;
    
    @Column(nullable = true)
    private String photos;
    
    @ManyToOne
    private User user;

    @ManyToOne
//    @ManyToOne(targetEntity = RecipeCategory.class, cascade = CascadeType.ALL,fetch= FetchType.EAGER)
//  @JoinColumn(name="category_id", nullable=false)
    public RecipeCategory recipeCategory;


    @Transient
    public String getPhotosImagePath() {
        if (photos == null || id == 0) return null;

        return "/recipe-photos/" + id + "/" + photos;
    }

}
