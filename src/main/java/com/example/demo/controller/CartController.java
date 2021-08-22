package com.example.demo.controller;

import com.example.demo.service.CartService;
import com.example.demo.service.ItemService;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final MemberService memberService;
    private final ItemService itemService;

//    @GetMapping("/cart")
//    public String createForm(Model model) {
//
//        List<MemberEntity> members = memberService.findMembers();
//        List<Item> items = itemService.findItems();
//
//        model.addAttribute("members", members);
//        model.addAttribute("items", items);
//
//        return "redirect:/items";
//    }
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
