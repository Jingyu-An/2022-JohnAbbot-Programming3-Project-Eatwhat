package com.example.eatwhat.model;

import jdk.jfr.Name;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @NotBlank
    private String recipeTitle;

    @NotBlank
    private String recipeDescription;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date recipeDate;

    private int point;
    
    @Column(nullable = true, length = 64)
    private String photos;
    
    @OneToOne
    private User user;

    private long recipeCategoryId;
    
    @Transient
    public String getPhotosImagePath() {
        if (photos == null || id == 0) return null;
        
        return "/recipe-photos/" + id + "/" + photos;
    }

}
