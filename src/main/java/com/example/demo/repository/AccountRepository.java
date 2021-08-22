package com.example.demo.repository;

import com.example.demo.domain.entity.Account;
import com.example.demo.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
