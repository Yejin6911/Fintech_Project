package com.example.demo.domain.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter @Setter
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 10, nullable = true)
    private String name;

    @Column(length = 20, nullable = true)
    private String email;

    @Column(length = 100, nullable = true)
    private String password;

    @Column(length = 20, nullable = true)
    private String birthday;

    @Column(length = 30, nullable = true)
    private String phoneNumber;

    @OneToOne(mappedBy = "member")
    private Cart cart;


    @Builder
    public MemberEntity(Long id, String name, String email, String password, String birthday, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
    }
}