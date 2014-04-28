package de.mic.degraph.configuration;

import de.mic.degraph.configuration.types.YedOutput;

/**
 * This class represents the whole date for degraph configuration.
 * 
 * 
 */
public class ConfigDataHolder {

	YedOutput output;

	public ConfigDataHolder() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(output.toString());
		return sb.toString();
	}

	public YedOutput getOutput() {
		return output;
	}

	public void setOutput(YedOutput output) {
		this.output = output;
	}

}
