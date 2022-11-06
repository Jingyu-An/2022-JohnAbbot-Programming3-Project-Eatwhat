package com.example.eatwhat.controller;

import com.example.eatwhat.model.Recipe;
import com.example.eatwhat.model.User;
import com.example.eatwhat.service.RecipeService;
import com.example.eatwhat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        List<Recipe> listRecipes = recipeService.listAllByUser(user.getId());

        model.addAttribute("listRecipes", listRecipes);
        model.addAttribute("user", user);

        return "/user/index";
    }


    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") long id, Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);

        return "/user/edit";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") long id, Model model) {
        if (id == 1) {
            return "redirect:/user";
        }

        userService.delete(id);
        return "redirect:/logout";
    }
}
