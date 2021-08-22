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

    @GetMapping("/order")
    public String dispOrder(){return "order/sendmoney4";}


}
