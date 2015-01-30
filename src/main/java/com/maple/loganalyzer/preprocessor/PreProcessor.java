package com.maple.loganalyzer.preprocessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.maple.loganalyzer.data.InputLog;
import com.maple.loganalyzer.data.InputLogFormat;

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

	private File file;
	private FileReader fileReader;
	private BufferedReader bufferedReader;

	private List<String> listCompenent;
	private CompenentParser compenentParser;
	private UrlParser urlParser;

	public PreProcessor(String fileName) throws IOException {

		file = new File(fileName);
		fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);
		compenentParser = new CompenentParser();
		urlParser = new UrlParser();

	}

	public void runPreProcessor() throws IOException {

		listCompenent = new ArrayList<String>();
		String line;

		while ((line = bufferedReader.readLine()) != null) {
			listCompenent = compenentParser.parseCompenent(line);
			addCompenentToList();
		}
	}

	private void addCompenentToList() {
		
		for (InputLogFormat logFormat : InputLogFormat.values()) {

			switch (logFormat) {
			case STATUS_CODE:
				InputLog.listStatusCode.add(listCompenent.get(InputLogFormat.STATUS_CODE.ordinal()));
				break;
			case URL:
				InputLog.listUrl.add(urlParser.parseUrl(listCompenent.get(InputLogFormat.URL.ordinal())));
				break;
			case BROWSER:
				InputLog.listBrowser.add(listCompenent.get(InputLogFormat.BROWSER.ordinal()));
				break;
			case TIME:
				InputLog.listTime.add(listCompenent.get(InputLogFormat.TIME.ordinal()));
				break;
			default:
				System.out.println("지원되지 않는 로그 포맷입니다.");
				System.exit(-1);
				break;
				
			}
		}
	}

}
