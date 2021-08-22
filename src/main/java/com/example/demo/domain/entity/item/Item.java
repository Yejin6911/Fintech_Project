package com.example.demo.domain.entity.item;

import com.example.demo.domain.entity.CartItem;
import com.example.demo.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private int price;

    // 판매자 계좌번호
    private String sellerAccount;

    // 해당 상품의 정해진 할부 개월수
    private int loanCount;

    @Enumerated(EnumType.ORDINAL)
    private ItemRating rating;

    @Lob
    private String description;


    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
