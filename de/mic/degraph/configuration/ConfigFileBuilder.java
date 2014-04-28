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

	public File build(ConfigDataHolder data) {
		validate(data);
		String content = createContent(data);
		try {
			return writeContentToFile(data, content);
		} catch (IOException e) {
			System.err.println("File could not be written.");
		}
		throw new IllegalArgumentException("No File created!");
	}

	private File writeContentToFile(ConfigDataHolder data, String content)
			throws IOException {
		File configFile = new File(data.getConfigFilename().getAbsolutePath());

		if (!configFile.exists()) {
			configFile.createNewFile();
		}
		FileWriter writer = new FileWriter(configFile);
		BufferedWriter bWriter = new BufferedWriter(writer);
		bWriter.write(content);
		bWriter.close();
		return configFile;
	}

	String createContent(ConfigDataHolder data) {
		return "empty";
	}

	private void validate(ConfigDataHolder data) {
		if (data.getConfigFilename() == null)
			throw new IllegalArgumentException("No Filename set!");

	}
}
