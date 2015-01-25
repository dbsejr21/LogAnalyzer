package com.maple.test;

import org.springframework.stereotype.Service;

//@Service("jindo")
public class 진돗개 implements Dog{
	
	private int age;

	public void setAge(int age) {
		this.age = age;
	}

	public String bark() {
		return "으르렁";
	}
	
}
