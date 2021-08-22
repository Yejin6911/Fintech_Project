package com.example.demo.domain.entity;

import com.example.demo.domain.entity.item.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@NoArgsConstructor
public class CartItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private int price; //주문 가격

    public static CartItem createCartItem(Item item) {
        CartItem cartItem = new CartItem();
        cartItem.setItem(item);
        cartItem.setPrice(item.getPrice());

        return cartItem;
    }


    //==비즈니스 로직==//
//    public void cancel() {
//        getItem().addStock(count);
//    }

    //==조회 로직==//
}