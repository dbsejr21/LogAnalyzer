package com.maple.loganalyzer.main;

import java.io.IOException;

import com.maple.loganalyzer.data.InputLog;
import com.maple.loganalyzer.preprocessor.PreProcessor;

public class LogAnalyzerMain {
	public static void main(String[] args) throws IOException {
		
		
		PreProcessor preProcessor = new PreProcessor("input.log");
		preProcessor.runPreProcessor();
		
		System.out.println(InputLog.listStatusCode.size());
		System.out.println(InputLog.listUrl.size());
		System.out.println(InputLog.listBrowser.size());
		System.out.println(InputLog.listTime.size());
		
		
	}
}