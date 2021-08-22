package com.example.demo.controller;

import com.example.demo.domain.entity.MemberEntity;
import com.example.demo.service.AccountService;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class AccountController {
    private final AccountService accountService;
    private final MemberService memberService;

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

    @PostMapping("/api/account/balance")
    public String inquireBalance(@RequestBody Map<String, String> param) {
        return accountService.inquire(param);
    }

    @PostMapping("/api/account/order")
    public String DrawingTransfer(@RequestBody Map<String, String> param) {
        return accountService.order(param);
    }
}