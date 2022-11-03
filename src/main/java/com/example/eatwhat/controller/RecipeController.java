package com.example.eatwhat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/recipe")
public class RecipeController {


    @GetMapping({"", "/"})
    public String index(){

        return "/recipe/index";
    }

    @GetMapping("/signup")
    public String signUp(){

        return "/recipe/signup";
    }

}
