package de.mic.degraph.configuration.types;

import static de.mic.degraph.configuration.util.StringUtil.CRLF;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a list of cludings (exclude and include)
 * 
 */
public class Cludings {
	List<Cluding> cludings = new ArrayList<>();

	public void addCluding(Cluding clude) {
		cludings.add(clude);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Cluding c : cludings) {
			sb.append(c.toString());
			sb.append(CRLF);
		}
		return sb.toString();
	}
}
