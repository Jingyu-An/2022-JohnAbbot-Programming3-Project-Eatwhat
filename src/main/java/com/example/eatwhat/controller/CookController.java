package com.example.eatwhat.controller;

import com.example.eatwhat.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value="/cook")
public class CookController {


    @GetMapping({"", "/"})
    public String index(){
        return "/cook/index";
    }

    @GetMapping("/signup")
    public String signUp(){
        return "/cook/signup";
    }

}
