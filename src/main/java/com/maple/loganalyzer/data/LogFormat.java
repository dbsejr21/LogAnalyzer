package com.maple.loganalyzer.data;

/*
 * input.log의 포맷을 명시
 * Preprocessor 에서는 input.log가 아래 순서대로일 것으로 알고 전처리 수행 
 */
public enum LogFormat {
	StatusCode, Url, Browser, Time
}
