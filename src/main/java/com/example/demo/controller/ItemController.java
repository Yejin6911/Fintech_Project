package com.example.demo.controller;

import com.example.demo.domain.entity.Item;
import com.example.demo.domain.entity.ItemRating;
import com.example.demo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items")
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    @PostConstruct
    public void create() {

//        Book book = new Book();
//        book.setName(form.getName());
//        book.setPrice(form.getPrice());
//        book.setStockQuantity(form.getStockQuantity());
//        book.setAuthor(form.getAuthor());
//        book.setIsbn(form.getIsbn());

        Item item = new Item();
        item.setName("test");
        item.setPrice(10000);
        item.setStockQuantity(10);
        item.setLoanCount(3);
        item.setRating(ItemRating.FIVE);
        item.setDescription("테스트입니다.");

        itemService.saveItem(item);
    }

//    @GetMapping("/items/new")
//    public String createForm(Model model) {
//        model.addAttribute("form", new BookForm());
//        return "items/createItemForm";
//    }

//    @PostMapping("/items/new")




//    @GetMapping("items/{itemId}/edit")
//    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {
//        Book item = (Book) itemService.findOne(itemId);
//
//        BookForm form = new BookForm();
//        form.setId(item.getId());
//        form.setName(item.getName());
//        form.setPrice(item.getPrice());
//        form.setStockQuantity(item.getStockQuantity());
//        form.setAuthor(item.getAuthor());
//        form.setIsbn(item.getIsbn());
//
//        model.addAttribute("form", form);
//        return "items/updateItemForm";
//    }
//
//    @PostMapping("items/{itemId}/edit")
//    public String updateItem(@PathVariable Long itemId, @ModelAttribute("form") BookForm form) {
//
//        itemService.updateItem(itemId, form.getName(), form.getPrice(), form.getStockQuantity());
//
//        return "redirect:/items";
//    }
}





