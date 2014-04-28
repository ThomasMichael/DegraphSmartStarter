package de.mic.degraph.configuration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class ConfigFileBuilderTest {

	ConfigFileBuilder builder = new ConfigFileBuilder();

	@Test
	public void shouldGetSomeContent() {
		String content = builder.createContent(new ConfigDataHolder());
		assertNotNull(content);
	}

	@Test(expected = IllegalArgumentException.class)
	public void emptyContentShouldNotCreateFile() {

		builder.build(new ConfigDataHolder());
	}

	@Test
	public void someConfioFileShouldExistOnFilesystem() throws IOException {
		ConfigDataHolder data = new ConfigDataHolder();
		data.setConfigFilename(File.createTempFile("pre", "suff"));
		File build = builder.build(data);
		assertTrue(build.exists());
	}
}
