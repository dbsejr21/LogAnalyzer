package com.maple.loganalyzer.data;

import java.util.List;

public class Statistics {
	
	// 전체 라인 수
	public static final int COUNTER_FOR_LINE = 0;

	// 최다 호출 APIKEY
	public static List<Statistics.ApiKey> statApiKey;

	// 상태코드 별 횟수
	public static List<Statistics.StatusCode> statStatusCode;

	// 상위 3개의 API ServcieID와 각각의 요청수
	public static List<Statistics.ServiceId> statServiceId;

	// 피크 시간대
	public static List<Statistics.Time> statTime;

	// 웹 브라우저 사용 비율
	public static List<Statistics.Browser> statBrowser;
	
		

	public static class ApiKey {
		public String name;
		public int counter;
	}

	public static class StatusCode {
		public String name;
		public int counter;
	}

	public static class ServiceId {
		public String name;
		public int counter;
	}
	
	public static class Time {
		public String name;
		public int counter;
	}
	
	public static class Browser {
		public String name;
		public int counter;
	}

}
