package com.example.demo.dto;

import com.example.demo.domain.entity.MemberEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String birthday;
    private String phoneNumber;


    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .name(name)
                .birthday(birthday)
                .phoneNumber(phoneNumber)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password, String name, String birthday, String phoneNumber) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
    }
}