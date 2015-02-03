package com.maple.loganalyzer.main;

import java.io.IOException;

import com.maple.loganalyzer.analysis.Analyzer;
import com.maple.loganalyzer.data.OutputLog;
import com.maple.loganalyzer.preparer.Preparer;
import com.maple.loganalyzer.printer.TextPrinter;

public class LogAnalyzerMain {
	public static void main(String[] args) throws IOException {
		

		Preparer preparer = new Preparer();
		preparer.prepare();
		
		Analyzer analyzer = new Analyzer();
		analyzer.analyze();

		TextPrinter textPrinter = new TextPrinter("output.log");
		textPrinter.printAll();
		
	}
}