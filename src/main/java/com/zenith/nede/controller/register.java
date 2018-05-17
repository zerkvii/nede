package com.zenith.nede.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class register {

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("name","val");
        return "home/register";
    }

}
