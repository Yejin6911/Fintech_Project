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
    private MemberEntity memberEntity;
    private String finAcno;
    private String acno;

    public Account toEntity(){
        return Account.builder()
                .id(id)
                .memberEntity(memberEntity)
                .finAcno(finAcno)
                .acno(acno)
                .build();
    }


    @Builder
    public AccountDto(Long id, MemberEntity memberEntity, String finAcno, String acno) {
        this.id = id;
        this.memberEntity = memberEntity;
        this.finAcno = finAcno;
        this.acno = acno;
    }
}
