package com.example.demo.controller;

import com.example.demo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public String confirmAccount(@RequestBody Map<String, String> param){
        return accountService.confirm(param);
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