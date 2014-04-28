package de.mic.degraph.configuration.types;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds all defined slices.
 * 
 * @author thomicha
 * 
 */
public class Slices {
	List<Slice> slices = new ArrayList<>();

	public void addSlice(Slice slice) {
		slices.add(slice);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Slice slice : slices) {
			sb.append(slice.toString());
			sb.append("\n\r");
		}
		return sb.toString();
	}
}
