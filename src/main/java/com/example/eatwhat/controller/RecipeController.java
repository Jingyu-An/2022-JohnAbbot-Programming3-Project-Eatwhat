package com.example.eatwhat.controller;

import com.example.eatwhat.model.Recipe;
import com.example.eatwhat.model.RecipeCategory;
import com.example.eatwhat.model.User;
import com.example.eatwhat.service.RecipeCategoryService;
import com.example.eatwhat.service.RecipeService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@NoArgsConstructor
@RequestMapping(value = "/recipe")

public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private RecipeCategoryService recipeCategoryService;

//    @GetMapping({"", "/"})
//    public String index(Model model) {
//        return "sth" // TODO check it out
//    }

    public void initList(Model model) {
        List<Recipe> listRecipes = recipeService.listAll(); // Need to change with inner join
        model.addAttribute("listRecipes", listRecipes);
    }

    @GetMapping({"", "/"})
    public String index(Model model) {

        initList(model);
        return "/recipe/index";
    }

    @GetMapping("/signup")
    public String signUp(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        recipeService.save(recipe);
        System.out.println("recipe saved");
        return "/recipe/signup";
    }

    @RequestMapping(value = "/register/save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult bindingResult, Model model) throws IOException {

        if (bindingResult.hasErrors()) {
            model.addAttribute("recipe", recipe);
            return "/recipe/index";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        recipe.setUser(user);// insert user information
        recipeService.save(recipe);

        return index(model);
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") long id, Model model) {
        Recipe recipe = recipeService.get(id);
        model.addAttribute("recipe", recipe);

        return "/recipe/edit";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") long id, Model model) {
        recipeService.delete(id);

        return index(model);
    }


    @GetMapping("/showCreateRecipe")
    public String showCreateRecipe(Model model) {
        List<RecipeCategory> recipeCategories = recipeCategoryService.getAll();
        model.addAttribute("recipeCategories", recipeCategories);
        return "/recipe/newRecipe";
    }

    @RequestMapping(value = "/saveRecipe", method = RequestMethod.POST)
    public String saveNewRecipe(@ModelAttribute("newRecipe") Recipe recipe) {

        // add logged user to the recipe
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            User loggedUser = ((User) principal);
            recipe.setUser(loggedUser);
            System.out.println("new recipe : " + recipe);
        } else {
            System.out.println("principal object: " + principal);
        }






        System.out.println("saving a new recipe");
        recipeService.save(recipe);
        return "redirect:/"; //TODO redirect to list page

    }

}

