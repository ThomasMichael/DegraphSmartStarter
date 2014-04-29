package de.mic.degraph.configuration.types;

/**
 * This class holds one Including.
 * 
 */
public class Including extends Cluding {

	public Including(String content) {
		super(content);
	}

	@Override
	public String toString() {
		return "include = " + this.content;
	}
}
