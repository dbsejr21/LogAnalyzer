package com.maple.loganalyzer.preparer;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.maple.loganalyzer.data.InputLog;
import com.maple.loganalyzer.data.Parameter;
import com.maple.loganalyzer.data.Stat;
import com.maple.loganalyzer.data.Url;

/**
 * 
 * @author Deok
 * 
 * @Behavior InputLog의 각 리스트를 입력으로 하고, apikey, 상태코드, serviceID, 시간대, 브라우저를 카운팅하여
 *           해시맵에 저장
 * 
 */

public class Preparer {

	private LogParser logParser;

	public Preparer(String fileName) throws IOException {
		logParser = new LogParser(fileName);
	}

	public void prepare() throws IOException {
		
		while (logParser.runLogParser() != false) {
			countAll();
			clearAllList();
		}
	}
	
	private void clearAllList() {
		InputLog.listBrowser.clear();
		InputLog.listStatusCode.clear();
		InputLog.listTime.clear();
		InputLog.listUrl.clear();
	}

	private void countAll() {
		for (Url url : InputLog.listUrl) {
			countServiceId(url.serviceId);
			countApiKey(url.parameters);
		}

		for (String statusCode : InputLog.listStatusCode) {
			countStatusCode(statusCode);
		}

		for (String browser : InputLog.listBrowser) {
			countBrower(browser);
		}

		for (String time : InputLog.listTime) {
			// 2009-06-10 08:00:15
			String keyTime = time.substring(0, 16);
			countTime(keyTime);
		}
	}

	private void count(Map<String, Integer> map, String key) {
		if (map.containsKey(key)) {
			int count = map.get(key) + 1;
			map.put(key, count);
		} else {
			map.put(key, 1);
		}
	}

	private void countApiKey(List<Parameter> parameters) {
		for (Parameter parameter : parameters) {
			if (parameter.name.equals("apikey")) {
				String apikey = parameter.value;
				count(Stat.counterForApiKey, apikey);
			}
		}
	}

	private void countStatusCode(String statusCode) {
		count(Stat.counterForStatusCode, statusCode);
	}

	private void countServiceId(String serviceId) {
		count(Stat.counterForServiceId, serviceId);
	}

	private void countBrower(String browser) {
		count(Stat.counterForBrowser, browser);
	}

	private void countTime(String time) {
		count(Stat.counterForTime, time);
	}

}
