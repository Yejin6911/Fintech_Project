package com.example.demo.repository;

import com.example.demo.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Account, Long> {
}
