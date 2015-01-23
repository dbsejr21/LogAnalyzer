package com.maple.loganalyzer.preprocessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.maple.loganalyzer.data.Log;
import com.maple.loganalyzer.data.LogFormat;

/**
 * 
 * @author Deok
 * 
 * @Input Input - input.log
 * 
 * @Behavior - 통계를 내기전에 수행되는 전처리 작업 - input.log의 컴포넌트들을 추출하여 Log클래스의 각 컴포넌트용
 *           리스트에 저장
 * 
 */
public class PreProcessor {
	
	private UrlParser urlParser = new UrlParser();

	private File file;
	private FileReader fileReader;
	private BufferedReader bufferedReader;

	public PreProcessor(String fileName) throws IOException {
		file = new File(fileName);
		fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);
	}

	public void runPreProcessor() {

		List<String> listCompenent = new ArrayList<String>();
		

		for (LogFormat logFormat : LogFormat.values()) {

			if (logFormat.equals(LogFormat.STATUS_CODE)) {

			} else if (logFormat.equals(LogFormat.URL)) {

			} else if (logFormat.equals(LogFormat.BROWSER)) {

			} else if (logFormat.equals(LogFormat.TIME)) {

			} else {
				System.out.println("지원되지 않는 로그 포맷입니다.");
				System.exit(-1);
			}
		}
	}

	private List<String> parseLine() throws IOException {
		List<String> listCompenent;
		
		String line;
		line = bufferedReader.readLine();
		
		
				

		return listCompenent;
	}

}
