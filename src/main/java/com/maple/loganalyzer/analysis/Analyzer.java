package com.maple.loganalyzer.analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.maple.loganalyzer.data.OutputLog;
import com.maple.loganalyzer.data.Stat;
import com.maple.loganalyzer.util.SortUtil;

/**
 * 
 * @author Deok
 * 
 * @Behavior Stat 클래스의 해시맵에 카운팅된 데이터를 입력으로 하고, OutputLog 클래스에 최다 호출 apikey 등 최종 통계값을 저장
 * 
 *
 */

public class Analyzer {

	public static final int UNIT_OF_ANALYSIS = 1000;
	private SortUtil sortUtil;

	public Analyzer() {
		sortUtil = new SortUtil();
	}

	public void analyze() {

		OutputLog.mostCalledApikey = getMostCalledApiKey();
		OutputLog.numberOfCallStatusCode.addAll(getNumberOfCallStatusCode());
		OutputLog.topThreeServiceId.addAll(getTopThreeServiceId());
		OutputLog.peakTime = getPeakTime();
		OutputLog.useRatioBrower.addAll(getUseRatioBrower());

	}

	private String getMostCalledApiKey() {
		String mostCalledApiKey = null;
		int max = 0;
		Set<String> keySet = Stat.counterForApiKey.keySet();
		for (String key : keySet) {
			int count = Stat.counterForApiKey.get(key);
			if (max < count) {
				mostCalledApiKey = key;
			}
		}
		return mostCalledApiKey;
	}

	private List<String> getNumberOfCallStatusCode() {
		List<String> numberOfCallStatusCode = new ArrayList<String>();

		Set<String> keySet = Stat.counterForStatusCode.keySet();
		for (String key : keySet) {
			int count = Stat.counterForStatusCode.get(key);
			numberOfCallStatusCode.add(key + " : " + count);
		}

		Collections.sort(numberOfCallStatusCode);

		return numberOfCallStatusCode;
	}

	private List<String> getTopThreeServiceId() {
		List<String> topThreeServiceId = new ArrayList<String>();
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();

		sortedMap.putAll(sortUtil.sortMapByValue(Stat.counterForServiceId));
		
		Set<String> keySet = sortedMap.keySet();
		
		for(String key: keySet) {
			topThreeServiceId.add(key + " : " + sortedMap.get(key));
		}

		for (int index = 0; index < topThreeServiceId.size(); index++) {

			int indexToRemove = topThreeServiceId.size() - 1;
			if (topThreeServiceId.size() > 3) {
				topThreeServiceId.remove(indexToRemove);
			}
		}
		return topThreeServiceId;
	}

	private String getPeakTime() {
		
		String peakTime = null;
		int max = 0;
		Set<String> keySet = Stat.counterForTime.keySet();
		for (String key : keySet) {
			int count = Stat.counterForTime.get(key);
			if (max < count) {
				peakTime = key;
			}
		}
		return peakTime;
	}

	private List<String> getUseRatioBrower() {
		List<String> useRatioBrower = new ArrayList<String>();
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();

		sortedMap.putAll(sortUtil.sortMapByValue(Stat.counterForBrowser));
		
		Set<String> keySet = sortedMap.keySet();
		
		int sum = getNumberOfBrowser(sortedMap);
				
		for(String key: keySet) {
			useRatioBrower.add(key + " : " + calculateRatio(sortedMap.get(key), sum) + "%");
		}
				
		return useRatioBrower;
	}
	
	private int getNumberOfBrowser(Map<String, Integer> map) {
		
		int sum = 0;
		Set<String> keySet = map.keySet();
		for(String key: keySet) {
			sum += map.get(key);
		}
		return sum;
	}
	
	private String calculateRatio(int num, int denominator) {
		double result = (double)num / denominator * 100;
		return String.format("%.1f", result);
		
	}
	

}
