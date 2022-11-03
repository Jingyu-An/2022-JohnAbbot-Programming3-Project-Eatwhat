package com.example.eatwhat.controller;

import com.example.eatwhat.model.Recipe;
import com.example.eatwhat.model.User;
import com.example.eatwhat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping({"", "/"})
    public String index(){
        return "/user/index";
    }


    @GetMapping("/signup")
    public String signUp(Model model){
        User user = new User();
        model.addAttribute("user", user);
        System.out.println("This is user signup method");
        List<String> roleList = Arrays.asList("User", "Admin");
        model.addAttribute("roleList", roleList);
        return "/user/signup";
    }
    @RequestMapping(value = "/register/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getUserPassword());
        user.setUserPassword(encodedPassword);

        System.out.println(user.getAuth());
        if(user.getAuth().equals("Admin")){
            user.setAuth("ROLE_ADMIN,ROLE_USER");
        }else{
            user.setAuth("ROLE_USER");
        }

        userService.save(user);

        return "redirect:/login?site=user";
    }


}
