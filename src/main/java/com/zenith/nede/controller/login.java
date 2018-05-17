package com.zenith.nede.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class login {
    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("name","zerk");
        return "home/login";

    }
}
