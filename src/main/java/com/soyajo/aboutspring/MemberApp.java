package com.soyajo.aboutspring;

import com.soyajo.aboutspring.member.Grade;
import com.soyajo.aboutspring.member.Member;
import com.soyajo.aboutspring.member.MemberService;
import com.soyajo.aboutspring.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();


        /**
         * ApplicationContext = 스프링 컨테이너라 한다.
         * applicationContext.getBean() - 스프링 컨테이너를 통해서 서비스를 찾는다.
         * 개발자가 직접 자바코드로 모든 것들을 했다면 이제부터는 스프링 컨테이너에 객체를 스프링 빈으로 등록하고,
         * 스프링 컨테이너에서 스프링 빈을 찾아서 사용하도록 변경되었다.
         *
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);


        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
