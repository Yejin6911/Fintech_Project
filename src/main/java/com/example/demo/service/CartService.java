package com.example.demo.service;

import com.example.demo.domain.entity.Cart;
import com.example.demo.domain.entity.CartItem;
import com.example.demo.domain.entity.MemberEntity;
import com.example.demo.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    @Transactional
    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Transactional
    public void add(Long cartId, CartItem cartItem) {
        Cart cart = cartRepository.findById(cartId).get();
        cart.addCartItem(cartItem);
    }

    public MemberEntity findOwner(Long cartId) {
        return cartRepository.findById(cartId).get().getMember();
    }

    public List<CartItem> findCartItems(Long cartId) {
        return cartRepository.findById(cartId).get().getCartItems();
    }
}
