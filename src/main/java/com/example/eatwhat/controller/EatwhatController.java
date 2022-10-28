package com.example.eatwhat.controller;

import com.example.eatwhat.dao.RecipeRepository;
import com.example.eatwhat.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EatwhatController {
  
  @RequestMapping("/")
  public String homePage() {
    return "index";
  }
}
