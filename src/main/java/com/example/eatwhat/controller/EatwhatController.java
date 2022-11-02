package com.example.eatwhat.controller;

import com.example.eatwhat.model.Recipe;
import com.example.eatwhat.model.User;
import com.example.eatwhat.service.RecipeService;
import com.example.eatwhat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
  
  @Autowired
  private UserService userService;
  
  public void initList(Model model) {
    List<Recipe> listRecipes = recipeService.listAll();
    model.addAttribute("listRecipes", listRecipes);
  
    List<User> listUsers = userService.listAll();
    model.addAttribute("listUsers", listUsers);
  }
  
  @RequestMapping("/")
  public String homePage() {
    return "index";
  }
  
  @RequestMapping("/user/register")
  public String showUser(Model model) {
    User user = new User();
    model.addAttribute("user", user);
    
    return "register_user";
  }
  
  @RequestMapping(value = "/user/save", method = RequestMethod.POST)
  public String saveUser(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
  
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(user.getUserPassword());
    user.setUserPassword(encodedPassword);
    
    userService.save(user);
    
    return "redirect:/login";
  }
  
  
  // Recipe
  @RequestMapping("/recipe")
  public String viewRecipe(Model model) {
    
    initList(model);
    
    return "recipe";
  }
  @RequestMapping("/recipe/register")
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
  
}