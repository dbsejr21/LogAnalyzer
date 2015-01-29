package com.maple.loganalyzer.printer;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * 
 * @author Deok
 * 
 * @Description
 * 통계 결과를 파일로 출력
 *
 */
public class TextPrinter {
	private String outputFileName = "output.log";
	
	private FileWriter fileWriter; 
	private BufferedWriter bufferdWriter;
	private StringBuffer strBuffer;

}
