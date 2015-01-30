package com.maple.loganalyzer.analysis;

import java.util.List;

import com.maple.loganalyzer.data.InputLog;
import com.maple.loganalyzer.data.Statistics;

/**
 * 
 * @author Deok
 * 
 * @Description
 * Log클래스의 각 컴포넌트의 리스트들을 대상으로 통계하여 Statistics에 저장
 * 
 *
 */

public class Analyzer {
	
	private static final int UNIT_OF_ANALYSIS = 1000;
	
	
	public void analyze() {
		
		for(InputLog.Url url: InputLog.listUrl) {
			calculateApikeyStat(url);
		}
		
	}
	
	private void calculateApikeyStat(InputLog.Url url) {
		
		
		
		
		
	}
	
	
}
