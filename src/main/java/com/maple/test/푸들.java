package com.maple.test;

import org.springframework.stereotype.Service;

//@Service("poodle")
public class 푸들 implements Dog {
	
	private int age;
	
	public 푸들(int age) {
		this.age = age;
	}

	public String bark() {
		return "왕왕";
	}
	
	
}
