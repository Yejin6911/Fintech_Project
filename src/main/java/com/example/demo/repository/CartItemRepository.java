package com.example.demo.repository;

import com.example.demo.domain.entity.Cart;
import com.example.demo.domain.entity.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CartItemRepository {

    private final EntityManager em;


    public void save(CartItem cartItem) {
        em.persist(cartItem);
    }

    public Cart findOne(Long id) {
        return em.find(Cart.class, id);
    }

    public List<Cart> findAll() {
        return em.createQuery("select c from Cart c", Cart.class)
                .getResultList();
    }

}
