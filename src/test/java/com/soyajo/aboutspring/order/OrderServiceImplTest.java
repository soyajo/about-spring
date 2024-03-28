package com.soyajo.aboutspring.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.soyajo.aboutspring.discount.FixDiscountPolicy;
import com.soyajo.aboutspring.member.Grade;
import com.soyajo.aboutspring.member.Member;
import com.soyajo.aboutspring.member.MemberRepository;
import com.soyajo.aboutspring.member.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceImplTest {

	@Test
	void createOrder() {
		MemberRepository memberRepository = new MemoryMemberRepository();
		memberRepository.save(new Member(1L, "name", Grade.VIP));
		
		OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
		Order order = orderService.createOrder(1L, "itemA", 10000);
		assertThat(order.getDiscountPrice()).isEqualTo(1000);
		 
	}
}
