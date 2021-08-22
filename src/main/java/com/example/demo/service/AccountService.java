package com.example.demo.service;

import com.example.demo.api.AccountApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountApiClient accountApiClient;

    @Transactional(readOnly = true)
    public String registration(Map<String, String> param) {
        return accountApiClient.requestFinAccount(param);
    }

    @Transactional(readOnly = true)
    public String confirm(Map<String, String> param) {
        return accountApiClient.confirmFinAcoount(param);
    }

    public String inquire(Map<String, String> param) {
        return accountApiClient.inquireBalance(param);
    }

    public String order(Map<String, String> param) {
        String FinAcno = "00820100010630000000000011386";
        return accountApiClient.drawingTransfer(param, FinAcno);
    }
}
