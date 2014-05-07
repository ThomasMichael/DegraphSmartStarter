package de.mic.degraph.configuration.types;

import static de.mic.degraph.configuration.util.StringUtil.CRLF;

import java.io.File;

/**
 * This File holds the Filename für Yed.
 * 
 * @author thomicha
 * 
 */
public class YedOutput {

	File filename;

	public YedOutput(File filename) {
		super();
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "output = " + filename.getAbsolutePath() + CRLF;
	}

	public String getFilePath() {
		return filename.getAbsolutePath();
	}
}
