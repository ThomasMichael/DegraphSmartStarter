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

	public List<Cluding> getIncluding() {
		List<Cluding> result = new ArrayList<Cluding>();

		for (Cluding c : cludings) {
			if (c instanceof Including) {
				result.add(c);
			}
		}
		return result;
	}

	public List<Cluding> getExcluding() {
		List<Cluding> result = new ArrayList<Cluding>();

		for (Cluding c : cludings) {
			if (c instanceof Excluding) {
				result.add(c);
			}
		}
		return result;
	}
}
