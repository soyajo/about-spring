package com.soyajo.aboutspring.beanfind;

import com.soyajo.aboutspring.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    /**
     * 이 로그는 스프링 내부적으로 스프링 자체를 확장하려고 사용하는 빈들
     * name = org.springframework.context.annotation.internalConfigurationAnnotationProcessor, object = org.springframework.context.annotation.ConfigurationClassPostProcessor@2e77b8cf
     * name = org.springframework.context.annotation.internalAutowiredAnnotationProcessor, object = org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor@4cc547a
     * name = org.springframework.context.annotation.internalCommonAnnotationProcessor, object = org.springframework.context.annotation.CommonAnnotationBeanPostProcessor@7555b920
     * name = org.springframework.context.event.internalEventListenerProcessor, object = org.springframework.context.event.EventListenerMethodProcessor@4152d38d
     * name = org.springframework.context.event.internalEventListenerFactory, object = org.springframework.context.event.DefaultEventListenerFactory@3591009c
     * <p>
     *
     * AppConfig 도 스프링 컨테이너에 등록 됨.
     * name = appConfig, object = com.soyajo.aboutspring.AppConfig$$SpringCGLIB$$0@5398edd0
     * name = memberService, object = com.soyajo.aboutspring.member.MemberServiceImpl@b5cc23a
     * name = memberRepository, object = com.soyajo.aboutspring.member.MemoryMemberRepository@5cc5b667
     * name = orderService, object = com.soyajo.aboutspring.order.OrderServiceImpl@61edc883
     * name = discountPolicy, object = com.soyajo.aboutspring.discount.RateDiscountPolicy@758f4f03
     */
    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + ", object = " + bean);
        }
    }


    /**
     *
     * application bean만 출력
     * name = appConfig, object = Generic bean: class [com.soyajo.aboutspring.AppConfig$$SpringCGLIB$$0]; scope=singleton; abstract=false; lazyInit=null; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodNames=null; destroyMethodNames=null
     * name = memberService, object = Root bean: class [null]; scope=; abstract=false; lazyInit=null; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=appConfig; factoryMethodName=memberService; initMethodNames=null; destroyMethodNames=[(inferred)]; defined in com.soyajo.aboutspring.AppConfig
     * name = memberRepository, object = Root bean: class [null]; scope=; abstract=false; lazyInit=null; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=appConfig; factoryMethodName=memberRepository; initMethodNames=null; destroyMethodNames=[(inferred)]; defined in com.soyajo.aboutspring.AppConfig
     * name = orderService, object = Root bean: class [null]; scope=; abstract=false; lazyInit=null; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=appConfig; factoryMethodName=orderService; initMethodNames=null; destroyMethodNames=[(inferred)]; defined in com.soyajo.aboutspring.AppConfig
     * name = discountPolicy, object = Root bean: class [null]; scope=; abstract=false; lazyInit=null; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=appConfig; factoryMethodName=discountPolicy; initMethodNames=null; destroyMethodNames=[(inferred)]; defined in com.soyajo.aboutspring.AppConfig
     */
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findAllApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            // Role ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            // Role ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("name = " + beanDefinitionName + ", object = " + beanDefinition);
            }
        }
    }


}
