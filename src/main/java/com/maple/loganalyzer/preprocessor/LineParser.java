package com.maple.loganalyzer.preprocessor;

import java.util.ArrayList;
import java.util.List;

import com.maple.loganalyzer.data.Log;
import com.maple.loganalyzer.util.PatternMatcher;

public class LineParser {
	private PatternMatcher patternMatcher;
	
	public List<String> parseLine(String line) {
		List<String> listCompenent = new ArrayList<String>();
		listCompenent = patternMatcher.getMatchedStrings(line, Log.PREFIX_FOR_COMPENENT, Log.SUFFIX_FOR_COMPENENT);
		return listCompenent;
	}
}
