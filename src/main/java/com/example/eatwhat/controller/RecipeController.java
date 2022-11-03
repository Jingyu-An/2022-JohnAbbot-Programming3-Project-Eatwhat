package com.example.eatwhat.controller;

import com.example.eatwhat.model.Recipe;
import com.example.eatwhat.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value="/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping({"", "/"})
    public String index(Model model) {
    
        List<Recipe> listRecipes = recipeService.listAll(); // Need to change with inner join
        model.addAttribute("listRecipes", listRecipes);
        
        return "/recipe/index";
    }

    @GetMapping("/signup")
    public String signUp(Model model){
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        System.out.println("This is signup method");
        return "/recipe/signup";
    }
    
    @RequestMapping(value = "/register/save", method = RequestMethod.POST)
    public String saveRecipe(@ModelAttribute("recipe") Recipe recipe,
                                   @RequestParam("image") MultipartFile multipartFile, Model model) throws IOException {
        recipeService.save(recipe, multipartFile);

        return index(model);
    }
}
