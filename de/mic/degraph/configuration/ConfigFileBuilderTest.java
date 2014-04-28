package de.mic.degraph.configuration;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;


public class ConfigFileBuilderTest {

	ConfigFileBuilder builder = new ConfigFileBuilder();

	@Test
	public void shouldGetSomeContent() {
		String content = builder.createContent(new ConfigDataHolder());
		assertNotNull(content);
	}
}
