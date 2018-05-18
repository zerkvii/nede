package com.zenith.nede.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class login {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login_view(Model model){
        model.addAttribute("name","zerk");
        return "home/login";

    }

}
