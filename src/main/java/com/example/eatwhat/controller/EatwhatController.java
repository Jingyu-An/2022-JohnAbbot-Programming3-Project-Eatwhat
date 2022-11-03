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

//    @Autowired
//    private RecipeService recipeService;

//    @Autowired
//    private UserService userService;
//

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
    public String login(@RequestParam String site, Model model){
        model.addAttribute("site", site);
        return "loginForm";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String site, Model model){
        model.addAttribute("site", site);
        return "redirect:/"+site;
    }

    @GetMapping("/signup")
    public String signUp(@RequestParam String site){
        System.out.println("signup");
        return "redirect:/"+site+"/signup";
    }


//    @RequestMapping("/user/register")
//    public String showUser(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        List<String> roleList = Arrays.asList("User", "Admin");
//        model.addAttribute("roleList", roleList);
//        return "register_user";
//    }
//
//    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
//    public String saveUser(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
//
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(user.getUserPassword());
//        user.setUserPassword(encodedPassword);
//
//        System.out.println(user.getAuth());
//        if(user.getAuth().equals("Admin")){
//            user.setAuth("ROLE_ADMIN,ROLE_USER");
//        }else{
//            user.setAuth("ROLE_USER");
//        }
//
//        userService.save(user);
//
//        return "redirect:/login";
//    }


//    @RequestMapping(value = "/recipe/save", method = RequestMethod.POST)
//    public RedirectView saveRecipe(@ModelAttribute("recipe") Recipe recipe,
//                                   @RequestParam("image") MultipartFile multipartFile) throws IOException {
//        recipeService.save(recipe, multipartFile);
//
//        return new RedirectView("/recipe", true);
//    }

}