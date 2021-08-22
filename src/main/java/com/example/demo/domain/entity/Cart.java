package com.example.demo.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart {

    @Id @GeneratedValue
    @Column(name = "cart_id")
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>();

    private LocalDateTime orderDate; //주문시간

    @Enumerated(EnumType.STRING)
    private CartStatus status; // 카드 주문상태 [BEFORE_ORDER, AFTER_ORDER]

    //==연관관계 메서드==//
    public void setMember(MemberEntity member) {
        this.member = member;
        member.setOrder(this);

    }

    public void addCartItem(CartItem orderItem) {
        cartItems.add(orderItem);
        orderItem.setCart(this);
    }


    //==카트 생성 메서드==//
    public static Cart createOrder(MemberEntity member) {
        //생성 후 장바구니 가질 멤버 지정
        Cart order = new Cart();
        order.setMember(member);

        order.setStatus(CartStatus.BEFORE_ORDER);

        // 나중에 주문후 지정하자
//        order.setOrderDate(LocalDateTime.now());
        return order;
    }

    //==비즈니스 로직==//
    /**
     * 주문 취소
     */
//    public void cancel() {
////        if (delivery.getStatus() == DeliveryStatus.COMP) {
////            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
////        }
//
//        this.setStatus(CartStatus.CANCEL);
//        for (CartItem orderItem : orderItems) {
//            orderItem.cancel();
//        }
//    }

    //==조회 로직==//
    /**
     * 전체 장바구니 가격 조회
     */
    public int getTotalPrice() {
        int totalPrice = 0;
        for (CartItem cartItem : cartItems) {
            totalPrice += cartItem.getPrice();
        }
        return totalPrice;
    }

}