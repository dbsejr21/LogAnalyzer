package com.maple.loganalyzer.data;

import java.util.HashMap;
import java.util.Map;

public class Stat {
	
	// 최다 호출 APIKEY을 구해야 함
	// APIKEY 별 누적 카운트
	public static Map<String, Integer> counterForApiKey = new HashMap<String, Integer>();

	// 상태코드 별 횟수를 구해야 함
	// 상태코드 별 누적 카운트
	public static Map<String, Integer> counterForStatusCode = new HashMap<String, Integer>();

	// 상위 3개의 API ServcieID와 각각의 요청수를 구해야 함
	// ServiceID 별 누적 카운트
	public static Map<String, Integer> counterForServiceId = new HashMap<String, Integer>();
	
	// 피크 시간대를 구해야 함
	// 시간대 별 누적 카운트(분 단위 이상)
	public static Map<String, Integer> counterForTime = new HashMap<String, Integer>();

	// 웹 브라우저 사용 비율를 구해야함
	// 브라우저 별 누적 카운트
	public static Map<String, Integer> counterForBrowser = new HashMap<String, Integer>();
	
}
