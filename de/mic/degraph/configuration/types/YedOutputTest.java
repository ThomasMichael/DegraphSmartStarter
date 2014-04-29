package de.mic.degraph.configuration.types;

import static de.mic.degraph.configuration.util.StringUtil.CRLF;
import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

public class YedOutputTest {

	@Test
	public void testOutput() throws Exception {
		String filename = "MyName.graphml";
		String expected = "output = " + new File(filename).getAbsolutePath()
				+ CRLF;
		YedOutput yedOutput = new YedOutput(new File(filename));
		assertEquals(expected, yedOutput.toString());
	}
}
