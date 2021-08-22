package com.example.demo.repository;

import com.example.demo.domain.entity.Cart;
import com.example.demo.domain.entity.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem,Long> {
}
