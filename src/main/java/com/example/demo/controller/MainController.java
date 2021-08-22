package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MainController {
    @GetMapping("/")
    public String main(){
        return "home/index";
    }

    @GetMapping("/order")
    public String order() {
        return "order/sendmoney3";
    }
}
