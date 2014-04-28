package de.mic.degraph.configuration;

import java.io.File;

/**
 * This class represents the whole date for degraph configuration.
 * 
 * 
 */
public class ConfigDataHolder {

	File configFilename;

	public ConfigDataHolder() {
		super();
	}

	public void setConfigFilename(File fileToSave) {
		this.configFilename = fileToSave;
	}
}
