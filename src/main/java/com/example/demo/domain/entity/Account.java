package com.example.demo.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

    @Column(length = 50)
    private String finAcno;

    @Builder
    public Account(Long id, MemberEntity memberEntity, String finAcno) {
        this.id = id;
        this.memberEntity = memberEntity;
        this.finAcno = finAcno;
    }

}
