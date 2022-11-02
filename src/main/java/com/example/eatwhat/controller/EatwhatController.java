package com.example.eatwhat.controller;

import com.example.eatwhat.model.Recipe;
import com.example.eatwhat.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

@Controller
public class EatwhatController {
  
  @Autowired
  private RecipeService recipeService;
  
  @RequestMapping("/")
  public String homePage() {
    return "index";
  }
  
  @RequestMapping("/register_recipe")
  public String showRecipe(Model model) {
    Recipe recipe = new Recipe();
    model.addAttribute("recipe", recipe);
    
    return "register_recipe";
  }
  
  @RequestMapping(value = "/recipe/save", method = RequestMethod.POST)
  public RedirectView saveRecipe(@ModelAttribute("recipe") Recipe recipe,
                                 @RequestParam("image")MultipartFile multipartFile) throws IOException {
    recipeService.save(recipe, multipartFile);
  
    return new RedirectView("/recipe", true);
  }
  
  @RequestMapping("/recipe")
  public String viewRecipe(Model model) {
    List<Recipe> listRecipes = recipeService.listAll();
    model.addAttribute("listRecipes", listRecipes);
  
    return "recipe";
  }
}