package com.maple.loganalyzer.preprocessor;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class PreProcessorTest {
	
	PreProcessor preProcessor;
	
	@Before
	public void setup() throws IOException {
		preProcessor = new PreProcessor("input.log");

	}
	
	@Test
	public void runPreProcessor() {
		
	}

}
