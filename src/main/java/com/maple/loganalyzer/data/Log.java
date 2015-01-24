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
	public static List<Log.Url> listUrl = new ArrayList<Log.Url>();
	public static List<Browser> listBrowser = new ArrayList<Browser>();
	public static List<String> listTime = new ArrayList<String>();


	public class Url {

		public static final String PREFIX_FOR_SERVICE_ID = "http\\:\\/\\/apis\\.daum\\.net\\/search\\/";
		public static final String SUFFIX_FOR_SERVICE_ID = "\\?";
		
		public ServiceID serviceID;
		public List<Log.Url.Parameter> parameters = new ArrayList<Log.Url.Parameter>();
		
		public class Parameter {
			public String name;
			public String value;
		}
	}
	
}



