package com.example.demo.controller;

import com.example.demo.domain.entity.Cart;
import com.example.demo.domain.entity.CartItem;
import com.example.demo.domain.entity.MemberEntity;
import com.example.demo.domain.entity.item.Item;
import com.example.demo.service.CartService;
import com.example.demo.service.ItemService;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping("/cart/{memberId}")
    public String createForm(@PathVariable Long memberId, Model model) {

//        //memberId 가 1인 멤버의 장바구니를 보여준다.
//        MemberEntity member = memberService.findMember(memberId);
//        Cart cart = member.getCart();
//
//        List<CartItem> cartItems = cart.getCartItems();
//
//        List<CartItem> input = new ArrayList<>();
//        for (CartItem cartItem : cartItems) {
//            input.add(cartItem);
//        }
//
//        model.addAttribute("member", member);
//        model.addAttribute("cartItems", input);
//        model.addAttribute("totalPrice", cart.getTotalPrice());
        return "cart/cartForm";
    }

    //장바구니 보여주기전 미리 세팅해 놓음
    @PostConstruct
    public void init() {

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
        memberService.save(member1);
        memberService.save(member2);

        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        cart1.setMember(member1);
        cart2.setMember(member2);

        cartService.saveCart(cart1);
        cartService.saveCart(cart2);

        Item item = new Item();
        item.setName("test");
        item.setPrice(10000);
        item.setLoanCount(3);
        item.setDescription("테스트입니다.");

        Item item2 = new Item();
        item2.setName("test");
        item2.setPrice(20000);
        item2.setLoanCount(2);
        item2.setDescription("테스트입니다2.");

        itemService.saveItem(item);
        itemService.saveItem(item2);

        CartItem cartItem1 = CartItem.createCartItem(item);
        CartItem cartItem2 = CartItem.createCartItem(item2);

        cartService.add(cart1.getId(), cartItem1);
        cartService.add(cart1.getId(), cartItem2);
    }
//
//    @PostMapping("/cart")
//    public String order() {
//
////        cartService.add(cartId, cartItemId);
//        return "redirect:/items";
//    }

//    @GetMapping("/orders")
//    public String orderList(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model) {
//        List<Cart> orders = cartService.findOrders(orderSearch);
//        model.addAttribute("orders", orders);
//
//        return "order/orderList";
//    }

//    @PostMapping("/orders/{orderId}/cancel")
//    public String cancelOrder(@PathVariable("orderId") Long orderId) {
//        orderService.cancelOrder(orderId);
//        return "redirect:/orders";
//    }
}
