package com.soyajo.aboutspring.singleton;

import com.soyajo.aboutspring.AppConfig;
import com.soyajo.aboutspring.member.MemberRepository;
import com.soyajo.aboutspring.member.MemberServiceImpl;
import com.soyajo.aboutspring.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    /**
     * 셋 다 같은 인스턴스가 나온다.
     *
     */
    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();
        System.out.println("memberService -> memberRepository1 = " + memberRepository1);
        System.out.println("orderService -> memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberRepository1).isSameAs(memberRepository);
        assertThat(memberRepository2).isSameAs(memberRepository);
    }

    /**
     * AppConfigCGLIB$$ 프록시 객체가 AppConfig 자식 타입으로 생성되어 사용된다.
     * 프록시 객체 인 AppConfig$$SpringCGLIB$$0 로 대체가 되면서 싱글톤 패턴으로 만들어준다.
     * 하지만, @Configuration 어노테이션을 빼고 @Bean 만 사용한다면 AppConfig 클래스 객체가 그대로 사용되면서 싱글톤 패턴이 깨진다.
     *
     */
    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig appConfig = ac.getBean(AppConfig.class);

        System.out.println("appConfig = " + appConfig.getClass());
    }
}
