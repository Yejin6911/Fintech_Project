package com.example.demo;

import com.example.demo.domain.entity.Cart;
import com.example.demo.domain.entity.CartItem;
import com.example.demo.domain.entity.MemberEntity;
import com.example.demo.domain.entity.item.Item;
import com.example.demo.domain.entity.item.ItemRating;
import com.example.demo.repository.CartItemRepository;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
//@Transactional
class DemoApplicationTests {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void saveItemTest() {

        MemberEntity member1 = new MemberEntity(
                1L,
                "test1",
                "123@naver.com",
                "1234",
                "000000",
                "01012345678");
        MemberEntity member2 = new MemberEntity(
                2L,
                "test2",
                "123@naver.com",
                "1234",
                "000000",
                "01012345678");
        memberRepository.save(member1);
        memberRepository.save(member2);


        Cart cart1 = new Cart();

        Cart cart2 = new Cart();

        cartRepository.save(cart1);
        cartRepository.save(cart2);

        cart1.setMember(member1);
        cart2.setMember(member2);

        Item item = new Item();
        item.setName("test");
        item.setPrice(10000);
        item.setLoanCount(3);
        item.setRating(ItemRating.FIVE);
        item.setDescription("테스트입니다.");

        Item item2 = new Item();
        item2.setName("test");
        item2.setPrice(20000);
        item2.setLoanCount(2);
        item2.setRating(ItemRating.FIVE);
        item2.setDescription("테스트입니다2.");

        itemRepository.save(item);
        itemRepository.save(item2);

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart1);
        cartItem.setItem(item);
        cartItemRepository.save(cartItem);


        System.out.println("cart1.getMember().getName() = " + cart1.getMember().getName());
    }
}
