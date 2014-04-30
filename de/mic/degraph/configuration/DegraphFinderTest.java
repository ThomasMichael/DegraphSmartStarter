package de.mic.degraph.configuration;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Test;

public class DegraphFinderTest {

	// public void
	@Test
	public void shouldFindDegraph() throws Exception {
		DegraphFinder degraphFinder = new DegraphFinder();
		File find = degraphFinder.find(new File(File.separator + "Temp"));
		assertNotNull(find);
	}
}
