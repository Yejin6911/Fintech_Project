package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MainController {
    @GetMapping("/")
    public String main(){
        return "index.html";
    }

    @GetMapping("/account")
    public String bank(){
        return "account/account.html";
    }

    @GetMapping("/order")
    public String order(){
        return "account/order.html";
    }
}
