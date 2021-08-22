package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomeController {

    @GetMapping("/home")
    public String dispHome(){
        return "home/index";
    }

    @GetMapping("home/customizing")
    public String dispCustomizing(){
        return "home/landing";
    }

    @GetMapping("home/customized")
    public String dispCustomized(){
        return "home/customized";
    }


}
