package com.soyajo.aboutspring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 예제 유지용 - @Configuration 사용한 쪽 제외 처리
)
public class AutoAppConfig {

}
