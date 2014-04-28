package de.mic.degraph.configuration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Creates a new Configfile
 * 
 * @author thomicha
 * 
 */
public class ConfigFileBuilder {

	public void build(ConfigDataHolder data) {
		validate(data);
		String content = createContent(data);
		try {
			writeContentToFile(data, content);
		} catch (IOException e) {
			System.err.println("File could not be written.");
		}

	}

	private void writeContentToFile(ConfigDataHolder data, String content)
			throws IOException {
		File configFile = new File(data.getConfigFilename().getAbsolutePath());

		if (!configFile.exists()) {
			configFile.createNewFile();
		}
		FileWriter writer = new FileWriter(configFile);
		BufferedWriter bWriter = new BufferedWriter(writer);
		bWriter.write(content);
		bWriter.close();

	}

	String createContent(ConfigDataHolder data) {
		return "empty";
	}

	private void validate(ConfigDataHolder data) {
		assert data.getConfigFilename() != null : "No Filename set!";

	}
}
