package com.soyajo.aboutspring.order;

import com.soyajo.aboutspring.discount.DiscountPolicy;
import com.soyajo.aboutspring.discount.FixDiscountPolicy;
import com.soyajo.aboutspring.discount.RateDiscountPolicy;
import com.soyajo.aboutspring.member.Member;
import com.soyajo.aboutspring.member.MemberRepository;
import com.soyajo.aboutspring.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {



    /**
     * 할인 정책을 변경하려면 클라이언트인 OrderServiceImpl 소스코드를 고쳐야 한다.
     * DIP 위반 - DiscountPolicy discountPolicy = new RateDiscountPolicy() <---추상화만 의존해야하는데 rate 를 의존하고있다.
     * OCP 위반 - 확장에는 열여있고 변경에 닫혀야 하는데 RateDiscountPolicy, FixDiscountPolicy 을 변경을 해야하기 때문에 위반
     * 다양성 만으로는 DIP, OCP 를 지킬 수가 없다.
     * 해결 방법 - 스프링 DI로 해결 가능.
     */
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    /**
     * AppConfig 쪽에서  구현 객체를 생성
     * 생성자 주입
     */
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    /**
     * 의존관계 자동 생성자 주입
     * @param memberRepository
     * @param discountPolicy
     */
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
