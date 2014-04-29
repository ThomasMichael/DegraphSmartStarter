package de.mic.degraph.configuration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import de.mic.degraph.configuration.types.Group;
import de.mic.degraph.configuration.types.YedOutput;

public class ConfigFileBuilderTest {

	ConfigFileBuilder builder = new ConfigFileBuilder();

	@Test(expected = Exception.class)
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
		data.setOutput(new YedOutput(File.createTempFile("pre", "suff")));
		File build = builder.build(data);
		assertTrue(build.exists());
	}

	@Test
	public void fileShouldHaveOutputForYed() throws Exception {
		String yedFileName = "thomas.graphml";
		ConfigDataHolder data = new DataFactory().getTestdata(yedFileName);
		File build = builder.build(data);
		String fileContent = getFileInput(build);
		assertTrue(fileContent.contains(yedFileName));
		build.delete();
	}

	@Test
	public void fileShouldHaveSlice() throws Exception {
		ConfigDataHolder data = new ConfigDataHolder();
		data.addGroup(new Group("part", "de.mic.*.(*).**"));
		data.setOutput(new YedOutput(new File("dosntMatter")));
		File build = builder.build(data);
		String fileContent = getFileInput(build);
		assertTrue(fileContent.contains("part"));
		assertTrue(fileContent.contains("de.mic."));
		build.delete();
	}

	private String getFileInput(File file) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(file));

			while ((sCurrentLine = br.readLine()) != null) {
				sb.append(sCurrentLine);
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return sb.toString();
	}

	private class DataFactory {

		public ConfigDataHolder getTestdata(String yedFileName) {
			ConfigDataHolder data = new ConfigDataHolder();
			data.addGroup(new Group("part", "de.mic.*.(*).**"));
			data.setOutput(new YedOutput(new File(yedFileName)));
			return data;
		}
	}
}
