package com.maple.loganalyzer.main;

import java.io.IOException;

import com.maple.loganalyzer.data.Log;
import com.maple.loganalyzer.preprocessor.PreProcessor;

public class LogAnalyzerMain {
	public static void main(String[] args) throws IOException {
		PreProcessor preProcessor = new PreProcessor("input.log");
		preProcessor.runPreProcessor();
		System.out.println(Log.listTime.size());
		System.out.println(Log.listBrowser.size());
		System.out.println(Log.listStatusCode.size());
		System.out.println(Log.listUrl.size());
	}
}