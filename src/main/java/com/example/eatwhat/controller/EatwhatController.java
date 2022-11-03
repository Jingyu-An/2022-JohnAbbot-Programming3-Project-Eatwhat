package com.example.eatwhat.controller;

import com.example.eatwhat.dao.UserRepository;
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

import javax.servlet.http.HttpServletRequest;
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

//    @GetMapping("/login")
//    public String login(@RequestParam String site,
//                        Model model) {
//        model.addAttribute("site", site);
//        loginErrorSite = site;
//        System.out.println("Login : site - " + site);
//        return "loginForm";
//    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request,@RequestParam String site,Model model) {
        String referrer = request.getHeader("Referer");
        request.getSession().setAttribute("prevPage", referrer);
        model.addAttribute("site", site);
        loginErrorSite = site;
        return "loginForm";
    }


    @PostMapping("/login")
    public String loginPost(@RequestParam String site, Model model){
        System.out.println("login page : " + site);
        model.addAttribute("site", site);
        if(site.equals("manager"))
        {
            System.out.println("this is manager area");
            return "site";
        }
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