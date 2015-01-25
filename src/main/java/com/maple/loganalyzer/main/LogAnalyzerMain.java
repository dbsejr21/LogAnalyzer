package com.maple.loganalyzer.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maple.loganalyzer.analysis.Analyzer;
import com.maple.test.DogHouse;

public class LogAnalyzerMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		DogHouse dogHouse = context.getBean(DogHouse.class);
		dogHouse.singDogSound();
		
	}
}