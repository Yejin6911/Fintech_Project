package com.example.demo.controller;

import com.example.demo.domain.entity.Account;
import com.example.demo.dto.AccountDto;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import com.example.demo.service.MemberService;
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
        List<AccountDto> accountDtoList = accountService.getAccountList(userEmail);
        model.addAttribute("accountList", accountDtoList);
        return "home/index";
    }

    @GetMapping("/order")
    public String dispOrder(Principal principal, Model model){
        return "order/sendmoney4";
    }


}
