package com.maple.loganalyzer.printer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.maple.loganalyzer.data.OutputLog;

/**
 * 
 * @author Deok
 * 
 * @Description
 * 통계 결과를 파일로 출력
 *
 */
public class TextPrinter {
	
	private File file;
	private FileWriter fileWriter; 
	private BufferedWriter bufferdWriter;
	private StringBuffer stringBuffer;
	
	public TextPrinter(String fileName) throws IOException {
		file = new File(fileName);
		fileWriter = new FileWriter(file);
		bufferdWriter = new BufferedWriter(fileWriter);
		stringBuffer = new StringBuffer();
	}
	
	public void printAll() throws IOException {
		
		printMostCalledApikey();
		printNumberOfcallStatusCode();
		printTopThreeServiceId();
		printPeakTime();
		printUseRatioBrower();
		
		bufferdWriter.write(stringBuffer.toString());
		bufferdWriter.flush();
		fileWriter.close();
	}
	
	private void printMostCalledApikey() {
		String mostCalledApikey = OutputLog.mostCalledApikey;
		stringBuffer.append("최다호출 APIKEY\n");
		stringBuffer.append(mostCalledApikey + "\n");
		stringBuffer.append("\n");
		
	}
	
	private void printNumberOfcallStatusCode() {
		stringBuffer.append("상태코드 별 횟수\n");
		for (String numberOfcallStatusCode: OutputLog .numberOfCallStatusCode) {
			stringBuffer.append(numberOfcallStatusCode + "\n");
		}
		stringBuffer.append("\n");
	}
	
	private void printTopThreeServiceId() {
		stringBuffer.append("상위 3개의 API ServiceID와 각각의 요청 수\n");
		for (String topThreeServiceId: OutputLog.topThreeServiceId) {
			stringBuffer.append(topThreeServiceId + "\n");
		}
		stringBuffer.append("\n");
	}
	
	private void printPeakTime() {
		String peakTime = OutputLog.peakTime;
		stringBuffer.append("피크 시간대\n");
		stringBuffer.append(peakTime + "\n");
		stringBuffer.append("\n");
	}
	
	private void printUseRatioBrower() {
		stringBuffer.append("웹 브라우저 별 사용비율\n");
		for (String useRatioBrower: OutputLog.useRatioBrower) {
			stringBuffer.append(useRatioBrower + "\n");
		}
		stringBuffer.append("\n");
	}
	
}
