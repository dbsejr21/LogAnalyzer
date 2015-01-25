package com.maple.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

//@Service
public class DogHouse {
	
//	@Autowired

//	@Resource(name="poodle")
//	@Resource(name="jindo")
	private Dog dog;
	
	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public void singDogSound() {
		System.out.println(dog.bark());
	}
}
