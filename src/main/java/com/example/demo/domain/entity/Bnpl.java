package com.example.demo.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Bnpl {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

    @Column
    private Long remainPrice;

    @Column
    private Long leftMonth;

    @Column
    private LocalDate startDate;

    public Bnpl(Long id, MemberEntity memberEntity, Long remainPrice, Long leftMonth, LocalDate startDate) {
        this.id = id;
        this.memberEntity = memberEntity;
        this.remainPrice = remainPrice;
        this.leftMonth = leftMonth;
        this.startDate = startDate;
    }
}
