package com.example.demo.service;

import com.example.demo.api.AccountApiClient;
import com.example.demo.dto.AccountDto;
import com.example.demo.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
//@AllArgsConstructor
public class AccountService {

    private PaymentRepository paymentRepository;

    private final AccountApiClient bankApiClient;

    @Transactional(readOnly = true)
    public String registration(Map<String, String> param) {
        return bankApiClient.requestFinAccount(param);
    }

    @Transactional(readOnly = true)
    public String confirm(Map<String, String> param) {
        return bankApiClient.confirmFinAcoount(param);
    }

    public String inquire(Map<String, String> param) {
        return bankApiClient.inquireBalance(param);
    }




    @Transactional
    public Long setAccountInfo(AccountDto accountDto){
        return paymentRepository.save(accountDto.toEntity()).getId();
    }

}
