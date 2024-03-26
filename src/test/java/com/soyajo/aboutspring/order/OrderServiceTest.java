package com.soyajo.aboutspring.order;

import com.soyajo.aboutspring.AppConfig;
import com.soyajo.aboutspring.member.Grade;
import com.soyajo.aboutspring.member.Member;
import com.soyajo.aboutspring.member.MemberService;
import com.soyajo.aboutspring.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {


    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder() {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // then
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
