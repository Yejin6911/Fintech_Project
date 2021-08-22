package com.example.demo.repository;

import com.example.demo.domain.entity.Account;
import com.example.demo.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByMemberEntity(MemberEntity memberEntity);
    Account findByAcno(String acno);

}
