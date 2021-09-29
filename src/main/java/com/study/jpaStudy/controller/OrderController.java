package com.study.jpaStudy.controller;

import com.study.jpaStudy.domain.Member;
import com.study.jpaStudy.domain.item.Item;
import com.study.jpaStudy.service.ItemService;
import com.study.jpaStudy.service.MemberService;
import com.study.jpaStudy.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping("/order")
    public String createForm(Model model) {
        List<Member> members = memberService.findMembers();
        List<Item> items = itemService.findItems();

        model.addAttribute("members", members);
        model.addAttribute("items", items);
        return "order/orderForm";
    }

    @PostMapping("/order")
    public String order(@RequestParam("memberId") Long memberId,
                        @RequestParam("itemId") Long itemId,
                        @RequestParam("count") int count ) {
        // RequestParam : form submit 방식 으로 들어오면 넘어오는 value

        orderService.order(memberId, itemId, count);
        return "redirect:/orders";
    }

}
