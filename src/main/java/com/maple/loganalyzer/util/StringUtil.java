package com.maple.loganalyzer.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Deok
 * 
 * @Description prefix와 suffix 사이의 패턴에 일치하는 항목을 추출
 *
 */
public class StringUtil {
	private Pattern pattern;
	private Matcher matcher;

	public List<String> pickStringList(String rawString, String prefix, String suffix) {

		List<String> matchedStrings = new ArrayList<String>();
		String[] arrStr = null;

		pattern = Pattern.compile(prefix);
		arrStr = pattern.split(rawString);

		pattern = Pattern.compile(suffix);

		for (String string : arrStr) {
			matcher = pattern.matcher(string);
			while (matcher.find()) {
				int indexOfSuffix = matcher.end();
				matchedStrings.add(string.substring(0, indexOfSuffix - 1));
			}
		}
		return matchedStrings;
	}

	public String[] splitter(String rawString, String regex) {
		
		return rawString.split(regex);
		
	}

}