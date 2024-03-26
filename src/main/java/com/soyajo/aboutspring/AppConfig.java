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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DIP 완성
 * OCP 원칙 지켜짐.
 * 관심사의 분리 : 구현 객체를 생성하고 연결하는 역할과 실행하는 역할이 명확히 분리가 되었다.
 * 역할과 구현의 분리
 * - appConfig : 구성 영역
 * - orderService, memberService : 사용 영역
 * - 유지보수가 용이하게 됬다.
 *
 * @Configuration - 설정정보
 * @Bean - 스프링 빈 컨테이너에 등록됨.
 */
@Configuration
public class AppConfig {


    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
//        return new FixDiscountPolicy();
    }
}
