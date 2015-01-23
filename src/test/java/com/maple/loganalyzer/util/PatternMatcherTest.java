package com.maple.loganalyzer.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

public class PatternMatcherTest {
	
	private Pattern pattern;
	private Matcher matcher;

	private String prefix;
	private String suffix;
	
	@Before
	public void setup() {
		// TODO Auto-generated method stub
		
		

	}
	
	@Test
	public void regTest() {
		int a = 0;
		StringBuffer sb = new StringBuffer();
		pattern = Pattern.compile("\\[*\\]");
		matcher = pattern
				.matcher("[200][http://apis.daum.net/search/knowledge?apikey=23jf&q=daum][IE][2009-06-10 08:00:00]");

		while (matcher.find()) {
			a++;
			matcher.appendTail(sb);
			
			
		}
		System.out.println(sb);
		System.out.println(a);

	}

}
