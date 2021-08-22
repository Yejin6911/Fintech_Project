package com.example.demo.service;

import com.example.demo.api.AccountApiClient;
import com.example.demo.domain.entity.Account;
import com.example.demo.domain.entity.MemberEntity;
import com.example.demo.dto.AccountDto;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountApiClient accountApiClient;

    public final MemberRepository memberRepository;
    public final AccountRepository accountRepository;

    @Transactional(readOnly = false)
    public Long saveAccount(String finAcno, String userEmail, String acno) {
        MemberEntity memberEntity = memberRepository.findByEmail(userEmail).get();
        AccountDto accountDto = new AccountDto();
        accountDto.setFinAcno(finAcno);
        accountDto.setMemberEntity(memberEntity);
        accountDto.setAcno(acno);
        return accountRepository.save(accountDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public String registration(Map<String, String> param) {
        return accountApiClient.requestFinAccount(param);
    }

    @Transactional(readOnly = true)
    public String confirm(Map<String, String> param) {
        return accountApiClient.confirmFinAcoount(param);
    }

    @Transactional(readOnly = true)
    public String inquire(Map<String, String> param) {
        return accountApiClient.inquireBalance(param);
    }

    @Transactional(readOnly = true)
    public String order(Map<String, String> param) {
        Account account = accountRepository.findByAcno(param.get("Acno"));
        String FinAcno = account.getFinAcno();
        return accountApiClient.drawingTransfer(param, FinAcno);
    }

    public List<AccountDto> getAccountList(String userEmail) {
        MemberEntity memberEntity = memberRepository.findByEmail(userEmail).get();
        List<Account> accounts = accountRepository.findAllByMemberEntity(memberEntity);

        List<AccountDto> accountDtoList = new ArrayList<>();

        for(Account board: accounts) {
            AccountDto accountDto = AccountDto.builder()
                    .id(board.getId())
                    .memberEntity(board.getMemberEntity())
                    .finAcno(board.getFinAcno())
                    .build();
            accountDtoList.add(accountDto);
        }
        return accountDtoList;
    }

    public String getUsername(String userEmail) {
        MemberEntity memberEntity = memberRepository.findByEmail(userEmail).get();
        String username = memberEntity.getName();
        return username;
    }
}
