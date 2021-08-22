package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class OrderController {

    @GetMapping("/order/3times")
    public String disp3TimesBreakDown(){return "order/sendmoney3";}

    @GetMapping("/order/12times")
    public String disp12TimesBreakDown(){return "order/sendmoney12";}

    @GetMapping("order/success")
    public String dispOrderSuccess(){
        return "order/orderSuccess";
    }
}
