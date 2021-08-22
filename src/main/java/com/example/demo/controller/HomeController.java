package com.example.demo.controller;

import com.example.demo.dto.AccountDto;
import com.example.demo.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    private final AccountService accountService;

    @GetMapping("/home")
    public String dispHome(Principal principal, Model model){
        String userEmail = principal.getName();
        String username = accountService.getUsername(userEmail);
        List<AccountDto> accountDtoList = accountService.getAccountList(userEmail);
        model.addAttribute("username",username);
        model.addAttribute("accountList", accountDtoList);
        return "home/index";
    }

    @GetMapping("home/customizing")
    public String dispCustomizing(){
        return "home/landing";
    }

    @GetMapping("home/customized")
    public String dispCustomized(Principal principal, Model model){
        String userEmail = principal.getName();
        String username = accountService.getUsername(userEmail);
        model.addAttribute("username",username);
        return "home/customized";
    }


}
