package com.maple.loganalyzer.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

import com.maple.loganalyzer.data.Log;
import com.maple.loganalyzer.data.Log.Url.Parameter;
import com.maple.loganalyzer.preprocessor.UrlParser;

public class StringUtilTest {
	
	StringUtil stringUtil;
	
	private Pattern pattern;
	private Matcher matcher;

	@Before
	public void setup() {
		// TODO Auto-generated method stub
		stringUtil = new StringUtil();
	}


	@Test
	public void getMatchedStringsTest_라인파싱하여_로그컴퍼넌트들을_분리한다() {
		
		String line = "[200][http://apis.daum.net/search/knowledge?apikey=23jf&q=daum][IE][2009-06-10 08:00:00]";
		
		List<String> matchedStrings = new ArrayList<String>();
		
		matchedStrings = stringUtil.pickStringList(line, Log.PREFIX_FOR_COMPENENT, Log.SUFFIX_FOR_COMPENENT);
		
		for (String s: matchedStrings) {
			System.out.println(s);
		}
		System.out.println("\n");
	}
	
	
	@Test
	public void getMatchedStringsTest_URL파싱하여_ServiceID_분리한다() {
		
		String url = "http://apis.daum.net/search/knowledge?apikey=23jf&q=daum";
		
		List<String> matchedStrings = new ArrayList<String>();
		
		matchedStrings = stringUtil.pickStringList(url, Log.Url.PREFIX_FOR_SERVICE_ID, Log.Url.SUFFIX_FOR_SERVICE_ID);
		
		for (String s: matchedStrings) {
			System.out.println(s);
		}
		System.out.println("\n");
		
	}
	
	@Test
	public void getMatchedStringsTest_URL파싱하여_ServiceID와_파라미터_분리한다() {
		
		
		UrlParser urlParser = new UrlParser();
		
		String strUrl = "http://apis.daum.net/search/knowledge?apikey=23jf&q=daum&test=zz";
		
		Log.Url url = new Log.Url();
		
		
		url = urlParser.parseUrl(strUrl);
		
		System.out.println(url.serviceID);
		
		for (Log.Url.Parameter p: url.parameters) {
			System.out.println(p.name + " " + p.value);
		}
		
	}
	
	
	private String[] splitter(String string, String regex) {
		return string.split(regex);
	}
	
	
}