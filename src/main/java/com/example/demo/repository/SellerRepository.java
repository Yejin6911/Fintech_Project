package com.example.demo.repository;

import com.example.demo.domain.entity.item.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
