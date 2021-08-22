package com.example.demo.controller;

import com.example.demo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/api/account/register")
    public String postRequest(@RequestBody Map<String, String> param){
        return accountService.registration(param);
    }

    @PostMapping("/api/account/confirm")
    public String confirmAccount(@RequestBody Map<String, String> param, Principal principal){
        String FinAcno = accountService.confirm(param);
        String email = principal.getName();
        System.out.println(email);
        accountService.saveAccount(FinAcno, email);
        return FinAcno;
    }

    @PostMapping("/api/account/order")
    public String DrawingTransfer(@RequestBody Map<String, String> param) {
        return accountService.order(param);
    }

    @PostMapping("/api/account/inquire")
    public String InquireBalance(@RequestBody Map<String, String> param) {
        return accountService.inquire(param);
    }
}