package com.zenith.nede.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class home {
    @RequestMapping("/")
    public String helloHtml(Model model){
        model.addAttribute("name","zerk");
        return "home/home";
    }
}
