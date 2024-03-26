package com.soyajo.aboutspring;

import com.soyajo.aboutspring.discount.DiscountPolicy;
import com.soyajo.aboutspring.discount.FixDiscountPolicy;
import com.soyajo.aboutspring.discount.RateDiscountPolicy;
import com.soyajo.aboutspring.member.MemberRepository;
import com.soyajo.aboutspring.member.MemberService;
import com.soyajo.aboutspring.member.MemberServiceImpl;
import com.soyajo.aboutspring.member.MemoryMemberRepository;
import com.soyajo.aboutspring.order.OrderService;
import com.soyajo.aboutspring.order.OrderServiceImpl;

/**
 * DIP 완성
 * 관심사의 분리 : 구현 객체를 생성하고 연결하는 역할과 실행하는 역할이 명확히 분리가 되었다.
 *
 */
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
