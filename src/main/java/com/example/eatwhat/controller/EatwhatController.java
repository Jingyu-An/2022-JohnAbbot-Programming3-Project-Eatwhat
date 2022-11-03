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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class EatwhatController {

    private String loginErrorSite;

    @GetMapping("/")
    public String home(Model model){
        return "index";
    }
    
    @GetMapping("/home")
    public String recipeBoard(@RequestParam String site, Model model){
        model.addAttribute("site", site);
        return "redirect:/"+site;
    }

    @GetMapping("/login")
    public String login(@RequestParam String site,
                        Model model) {
        model.addAttribute("site", site);
        loginErrorSite = site;
        System.out.println("Login : site - " + site);
        return "loginForm";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String site, Model model){
        model.addAttribute("site", site);
        return "redirect:/"+site;
    }


    @GetMapping("/login-error")
    public String loginError(Model model){
        System.out.println("Login ERROR site : " + loginErrorSite);
        model.addAttribute("loginError", true);
        model.addAttribute("site", loginErrorSite);
        return "loginForm";
    }
    @GetMapping("/signup")
    public String signUp(@RequestParam String site){
        System.out.println("signup");
        return "redirect:/"+site+"/signup";
    }



}