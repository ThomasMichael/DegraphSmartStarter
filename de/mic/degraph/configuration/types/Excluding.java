package de.mic.degraph.configuration.types;

/**
 * This class holds one Excluding.
 * 
 */
public class Excluding extends Cluding {

	public Excluding(String content) {
		super(content);
	}

	@Override
	public String toString() {
		return "exclude = " + content;
	}
}
