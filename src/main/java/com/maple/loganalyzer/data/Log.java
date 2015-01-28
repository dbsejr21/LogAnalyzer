package com.maple.loganalyzer.data;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Deok
 * 
 * @Description
 * 로그 데이터 모델링
 *
 */
public class Log {
	
	public static final String PREFIX_FOR_COMPENENT = "\\[";
	public static final String SUFFIX_FOR_COMPENENT = "\\]";
			
	public static List<String> listStatusCode = new ArrayList<String>();
	public static List<Url> listUrl = new ArrayList<Url>();
	public static List<String> listBrowser = new ArrayList<String>();
	public static List<String> listTime = new ArrayList<String>();


	public static class Url {

		public static final String PREFIX_FOR_SERVICE_ID = "http\\:\\/\\/apis\\.daum\\.net\\/search\\/";
		public static final String SUFFIX_FOR_SERVICE_ID = "\\?";
		
		public ServiceID serviceID;
		public List<Parameter> parameters = new ArrayList<Parameter>();
		
		public static class Parameter {
			public static final String PREFIX_FOR_PARAMETER = "\\?";
			public static final String SUFFIX_FOR_PARAMETER = "\\&";
			public String name;
			public String value;
		}
	}
	
}



