package com.soyajo.aboutspring.autowired;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.soyajo.aboutspring.member.Member;

import io.micrometer.common.lang.Nullable;

public class AutoWiredTest {
	
	@Test
	void AutowiredOption() {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
	}
	
	static class TestBean {
		
		
		/**
		 * 호출 자체가 안된다. 
		 * @param noBean1
		 */
		@Autowired(required = false)
		public void setNoBean1(Member noBean1) { 
			System.out.println("noBean1 = " + noBean1);
		}
		
		/**
		 * 호출은 된다. 널로 들어옴
		 * @param noBean2
		 */
		@Autowired()
		public void setNoBean2(@Nullable Member noBean2) { 
			System.out.println("noBean2 = " + noBean2);
		}
		
		/**
		 * Optional.empty로 감싸진다.
		 * @param noBean3
		 */
		@Autowired()
		public void setNoBean3(Optional<Member> noBean3) { 
			System.out.println("noBean3 = " + noBean3);
		}
	}
	
}
