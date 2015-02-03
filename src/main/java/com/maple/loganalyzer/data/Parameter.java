package com.maple.loganalyzer.data;


public class Parameter {
	public static final String PREFIX_FOR_PARAMETER = "\\?";
	public static final String SUFFIX_FOR_PARAMETER = "\\&";
	
	public String name;
	public String value;
	
	public Parameter(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
}