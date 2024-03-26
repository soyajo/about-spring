package com.soyajo.aboutspring;

import com.soyajo.aboutspring.member.Grade;
import com.soyajo.aboutspring.member.Member;
import com.soyajo.aboutspring.member.MemberService;
import com.soyajo.aboutspring.member.MemberServiceImpl;
import com.soyajo.aboutspring.order.Order;
import com.soyajo.aboutspring.order.OrderService;
import com.soyajo.aboutspring.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
