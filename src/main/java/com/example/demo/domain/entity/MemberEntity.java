package com.example.demo.domain.entity;

import com.example.demo.domain.entity.cart.Cart;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
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

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
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