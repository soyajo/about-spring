package com.soyajo.aboutspring.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class StatefulServiceTest {

    /**
     * 사용자 a 는 10000원 주문을 넣었고 사용자 b 는 20000원 주문을 넣었습니다.
     * 사용자 a의 주문금액은 10000원 이어야하는데 검색 결과 20000원이 되었다.
     * 진짜 공유필드는 조심해야한다! 스프링 빈은 항상 무상태(stateless)로 설계하자.
     */
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);


        int userAPrice = statefulService1.order("userA", 10000);
        int userBPrice = statefulService2.order("userB", 20000);

//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);
        System.out.println("userAPrice = " + userAPrice);

//        assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }


    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}