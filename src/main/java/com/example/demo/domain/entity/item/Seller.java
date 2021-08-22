package com.example.demo.domain.entity.item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Seller {

    @Id @GeneratedValue
    @Column(name = "seller_id")
    private Long id;

    private String name;

    private String finAccount;

    @OneToMany(mappedBy = "seller")
    List<Item> items = new ArrayList<Item>();


}
