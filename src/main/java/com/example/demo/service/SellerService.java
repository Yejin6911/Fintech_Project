package com.example.demo.service;

import com.example.demo.domain.entity.item.Seller;
import com.example.demo.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SellerService {
    private final SellerRepository sellerRepository;

    @Transactional
    public void saveSeller(Seller seller) {
        sellerRepository.save(seller);
    }

    @Transactional
    public void updateSeller(Long sellerId, String name, String account) {
        Seller seller = sellerRepository.findById(sellerId).get();
        seller.setName(name);
        seller.setFinAccount(account);

    }

    public List<Seller> findSellers() {
        return sellerRepository.findAll();
    }

    public Seller findOne(Long sellerId) {
        return sellerRepository.findById(sellerId).get();
    }
}
