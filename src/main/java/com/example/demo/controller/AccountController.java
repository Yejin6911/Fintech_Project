package com.example.demo.controller;

import com.example.demo.dto.AccountDto;
import com.example.demo.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
//@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/api/account/register")
    public String postRequest(@RequestBody Map<String, String> param){
        return accountService.registration(param);
    }

    @PostMapping("/api/account/confirm")
    public String confirmAccount(@RequestBody Map<String, String> param){
        return accountService.confirm(param);
    }

    @PostMapping("/api/account/balance")
    public String inquireBalance(@RequestBody Map<String, String> param) {
        return accountService.inquire(param);
    }





}
