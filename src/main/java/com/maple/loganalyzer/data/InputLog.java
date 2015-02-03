package com.maple.loganalyzer.data;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Deok
 * 
 * @Description
 * 입력 로그 데이터 저장
 *
 */
public class InputLog {
	
	public static int totalLineNumber = 0;
	
	public static final String PREFIX_FOR_COMPENENT = "\\[";
	public static final String SUFFIX_FOR_COMPENENT = "\\]";
			
	public static List<String> listStatusCode = new ArrayList<String>();
	public static List<Url> listUrl = new ArrayList<Url>();
	public static List<String> listBrowser = new ArrayList<String>();
	public static List<String> listTime = new ArrayList<String>();


	
	
}


