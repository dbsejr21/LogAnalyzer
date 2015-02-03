package com.maple.loganalyzer.preprocessor;

import org.junit.Before;
import org.junit.Test;

import com.maple.loganalyzer.logparser.UrlParser;

public class UrlParserTest {
	
	UrlParser urlParser;
	
	@Before
	public void setup() {
		urlParser = new UrlParser();
	}
	
	@Test
	public void getServiceIdTest_ServiceID를_추출한다() {
		String strUrl = "http://apis.daum.net/search/knowledge?apikey=23jf&q=daum";
		String serviceId = urlParser.getServiceId(strUrl);
		
		System.out.println(serviceId);
	}

}
