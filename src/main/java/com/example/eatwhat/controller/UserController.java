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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private RecipeService recipeService;

    @GetMapping({"", "/"})
    public String index(Model model){
        
        List<Recipe> listRecipes = recipeService.listAll();
        model.addAttribute("listRecipes", listRecipes);
        return "/user/index";
    }





}
