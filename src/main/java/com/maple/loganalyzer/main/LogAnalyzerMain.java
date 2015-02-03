package com.maple.loganalyzer.main;

import java.io.IOException;
import java.util.Set;

import com.maple.loganalyzer.analysis.Analyzer;
import com.maple.loganalyzer.analysis.Preparer;
import com.maple.loganalyzer.data.OutputLog;
import com.maple.loganalyzer.data.Stat;
import com.maple.loganalyzer.logparser.LogParser;

public class LogAnalyzerMain {
	public static void main(String[] args) throws IOException {
		
		LogParser preProcessor = new LogParser("input.log");
		preProcessor.runPreProcessor();

		Preparer preparer = new Preparer();
		preparer.prepare();
		
		Analyzer analyzer = new Analyzer();
		analyzer.analyze();

		String mostCalledApikey = OutputLog.mostCalledApikey;
		System.out.println(mostCalledApikey);
		System.out.println("");
		
		for (String s: OutputLog.numberOfCallStatusCode) {
			System.out.println(s);
		}
		System.out.println("");
		
		for (String s: OutputLog.topThreeServiceId) {
			System.out.println(s);
		}
		System.out.println("");
		
		String peakTime = OutputLog.peakTime;
		System.out.println(peakTime);
		System.out.println("");

		for (String s: OutputLog.useRatioBrower) {
			System.out.println(s);
		}
		System.out.println("");
		
	}
}