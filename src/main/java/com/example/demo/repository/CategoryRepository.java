package com.example.demo.repository;

import com.example.demo.domain.entity.item.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
