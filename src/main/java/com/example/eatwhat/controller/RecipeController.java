package com.example.eatwhat.controller;

import com.example.eatwhat.model.Recipe;
import com.example.eatwhat.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value="/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    
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
    public String signUp(Model model){
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        System.out.println("This is signup method");
        return "/recipe/signup";
    }

    @RequestMapping(value = "/register/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("recipe") Recipe recipe,
                                   @RequestParam("image") MultipartFile multipartFile, Model model) throws IOException {
        recipeService.save(recipe, multipartFile);

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
}
