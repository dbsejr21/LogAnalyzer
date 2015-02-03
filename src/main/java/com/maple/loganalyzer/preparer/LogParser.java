package com.maple.loganalyzer.preparer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import com.maple.loganalyzer.data.InputLog;
import com.maple.loganalyzer.data.InputLogFormat;

/**
 * 
 * @author Deok
 * 
 * @Input input.log 파일
 * 
 * @Behavior - 통계를 내기전에 수행되는 전처리 작업 - input.log의 컴포넌트들을 추출하여 InputLog클래스의 각
 *           컴포넌트용 리스트에 저장
 * 
 */
public class LogParser {

	private RandomAccessFile randomAccessFile;
	private static final int UNIT_OF_PARSE_LINE = 1000;

	private List<String> listCompenent;
	private CompenentParser compenentParser;
	private UrlParser urlParser;

	public LogParser(String fileName) throws IOException {

		randomAccessFile = new RandomAccessFile("input.log", "r");
		compenentParser = new CompenentParser();
		urlParser = new UrlParser();

	}

	public boolean runLogParser() throws IOException {

		listCompenent = new ArrayList<String>();
		String line;

		for (int i = 0; i < UNIT_OF_PARSE_LINE; i++) {
			line = randomAccessFile.readLine();
			if (line != null) {
				listCompenent = compenentParser.parseCompenent(line);
				addCompenentToList();
			} else {
				return false;
			}
		}
		return true;
	}

	private void addCompenentToList() {

		for (InputLogFormat logFormat : InputLogFormat.values()) {

			switch (logFormat) {
			case STATUS_CODE:
				InputLog.listStatusCode.add(listCompenent
						.get(InputLogFormat.STATUS_CODE.ordinal()));
				break;
			case URL:
				InputLog.listUrl.add(urlParser.parseUrl(listCompenent
						.get(InputLogFormat.URL.ordinal())));
				break;
			case BROWSER:
				InputLog.listBrowser.add(listCompenent
						.get(InputLogFormat.BROWSER.ordinal()));
				break;
			case TIME:
				InputLog.listTime.add(listCompenent.get(InputLogFormat.TIME
						.ordinal()));
				break;
			default:
				System.out.println("지원되지 않는 로그 포맷입니다.");
				System.exit(-1);
				break;
			}
		}
	}

}
