package com.soyajo.aboutspring.scan;

import com.soyajo.aboutspring.AutoAppConfig;
import com.soyajo.aboutspring.member.MemberService;
import com.soyajo.aboutspring.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        System.out.println("memberService = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
