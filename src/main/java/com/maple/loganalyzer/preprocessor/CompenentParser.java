package com.maple.loganalyzer.preprocessor;

import java.util.ArrayList;
import java.util.List;

import com.maple.loganalyzer.data.InputLog;
import com.maple.loganalyzer.util.StringUtil;

public class CompenentParser {
	private StringUtil patternMatcher;
	
	public CompenentParser() {
		patternMatcher = new StringUtil();
	}
	
	public List<String> parseCompenent(String line) {
		List<String> listCompenent = new ArrayList<String>();
		listCompenent = patternMatcher.pickStringList(line, InputLog.PREFIX_FOR_COMPENENT, InputLog.SUFFIX_FOR_COMPENENT);
		return listCompenent;
	}
}
