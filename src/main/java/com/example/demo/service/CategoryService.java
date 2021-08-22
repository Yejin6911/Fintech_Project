package com.example.demo.service;

import com.example.demo.domain.entity.item.Category;
import com.example.demo.domain.entity.item.Seller;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Transactional
    public void updateSeller(Long categoryId, String name) {
        Category category = categoryRepository.findById(categoryId).get();
        category.setName(name);
    }

    public List<Category> findCategories() {
        return categoryRepository.findAll();
    }

    public Category findOne(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }
}
