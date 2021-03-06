package com.example.demo.domain.entity.item;

import com.example.demo.domain.entity.CartItem;
import com.example.demo.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private int price;

    // 해당 상품의 정해진 할부 개월수
    private int loanCount;

    @Lob
    private String description;


    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>();

}
