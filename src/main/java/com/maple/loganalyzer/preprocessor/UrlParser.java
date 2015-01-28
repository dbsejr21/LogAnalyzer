package com.maple.loganalyzer.preprocessor;

import java.util.ArrayList;
import java.util.List;

import com.maple.loganalyzer.data.Log;
import com.maple.loganalyzer.data.Log.Url;
import com.maple.loganalyzer.util.PatternMatcher;

/**
 * 
 * @author Deok
 *
 * @Description
 * URL을 받아서 ServiceID와 Parameter들을 Log.listUrl의 각 인스턴스에 저장
 * 
 */
public class UrlParser {
private PatternMatcher patternMatcher;
	
	public UrlParser() {
		patternMatcher = new PatternMatcher();
	}
	
	public Url parseUrl(String strUrl) {
		
		Log.Url url = new Log.Url();
		String serviceId = patternMatcher.getMatchedStrings(strUrl, Log.Url.PREFIX_FOR_SERVICE_ID, Log.Url.SUFFIX_FOR_SERVICE_ID).get(0);
		
		
		
		
		return null;
	}
}
