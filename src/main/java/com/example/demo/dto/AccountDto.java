package com.example.demo.dto;

import com.example.demo.domain.entity.Account;
import com.example.demo.domain.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private String account;

    public Account toEntity(){
        return Account.builder()
                .id(id)
                .account(account)
                .build();
    }


    @Builder
    public AccountDto(Long id, String account) {
        this.id = id;
        this.account = account;
    }
}
