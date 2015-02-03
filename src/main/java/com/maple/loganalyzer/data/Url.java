package com.maple.loganalyzer.data;

import java.util.ArrayList;
import java.util.List;

public class Url {

	public static final String PREFIX_FOR_SERVICE_ID = "http\\:\\/\\/apis\\.daum\\.net\\/search\\/";
	public static final String SUFFIX_FOR_SERVICE_ID = "\\?";
	
	
	public String serviceId;
	public List<Parameter> parameters = new ArrayList<Parameter>();
	
	
}
