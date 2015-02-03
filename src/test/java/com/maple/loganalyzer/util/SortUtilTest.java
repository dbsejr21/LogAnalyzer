package com.maple.loganalyzer.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class SortUtilTest {
	
	private Map<String, Integer> map;
	private SortUtil sortUtil;
	
	@Before
	public void setup() {
		map = new HashMap<String, Integer>();
		sortUtil = new SortUtil();
	}
	
	@Test
	public void sortMapToValueTest() {
		
		map.put("blog", 826);
		map.put("book", 790);
		map.put("image", 795);
		map.put("knowledge", 836);
		
		
//		sortUtil.sortMapByValue(map);
		
		List<String> sortedList = new ArrayList<String>();

		sortedList.addAll(sortUtil.sortMapByValue(map));

		System.out.println("\nresult");
		for (String s : sortedList) {
			System.out.println(s);
		}

	}

}
