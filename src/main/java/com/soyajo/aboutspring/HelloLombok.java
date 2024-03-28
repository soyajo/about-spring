package com.soyajo.aboutspring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelloLombok {

	private String name;
	private int age;
	
	
	public static void main(String[] args) {
		HelloLombok helloLombok = new HelloLombok();
		helloLombok.setName("soya");
		helloLombok.setAge(28);
		System.out.println();
	
	}
	
}
