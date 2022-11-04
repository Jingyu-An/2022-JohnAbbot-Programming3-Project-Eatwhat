package com.example.eatwhat.model;

import jdk.jfr.Name;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "eatwhat_recipe")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Name("recipe_id")
    private long id;

    private String recipeTitle;

    private String recipeDescription;

    private int recipePoint;

    private int cookingTime;
    
    @Column(nullable = true, length = 64)
    private String photos;
    
    @OneToOne
    private User user;

    @ManyToOne(targetEntity = RecipeCategory.class, cascade = CascadeType.ALL,fetch= FetchType.EAGER)
//  @JoinColumn(name="category_id", nullable=false)
    private RecipeCategory recipeCategory;


    @Transient
    public String getPhotosImagePath() {
        if (photos == null || id == 0) return null;

        return "/recipe-photos/" + id + "/" + photos;
    }

}
