package com.soyajo.aboutspring;

import com.soyajo.aboutspring.member.MemberService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "com.soyajo.aboutspring.member", // ComponentScan 범위 지정
//        basePackageClasses = AutoAppConfig.class, // class 로 범위 지정

        excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 예제 유지용 - @Configuration 사용한 쪽 제외 처리
)
public class AutoAppConfig {

}
