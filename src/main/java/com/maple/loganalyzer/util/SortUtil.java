package com.maple.loganalyzer.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortUtil {

	public List<String> sortMapByValue(Map<String, Integer> map) {

		List<String> sortedList = new ArrayList<String>();
		Map<String, Integer> sortedMap = new TreeMap<String, Integer>();

		for (Iterator i = sortKeyByValue(map).iterator(); i.hasNext();) {
			String key = (String) i.next();
			sortedList.add(key + " : " + map.get(key));
		}

		return sortedList;

	}
	
	public Map<String, Integer> sortMapByValue2(Map<String, Integer> map) {

		List<String> sortedList = new ArrayList<String>();
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();

		for (Iterator i = sortKeyByValue(map).iterator(); i.hasNext();) {
			String key = (String) i.next();
			sortedMap.put(key, map.get(key));
		}

		return sortedMap;

	}
	

	public List sortKeyByValue(final Map map) {
		List listKey = new ArrayList();
		listKey.addAll(map.keySet());
		Collections.sort(listKey, new Comparator() {
			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);
				if (v1 == null) {
					return (v2 == null) ? 0 : 1;
				} else if (v1 instanceof Comparable) {
					return ((Comparable) v1).compareTo(v2);
				} else {
					return 0;
				}
			}
		});
		Collections.reverse(listKey);
		return listKey;
	}

}
