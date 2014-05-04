package de.mic.degraph.configuration.types;

import static de.mic.degraph.configuration.util.StringUtil.CRLF;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a list of cludings (exclude and include)
 * 
 */
public class Cludings {
	Set<Cluding> cludings = new HashSet<>();

	public void addCluding(Cluding clude) {
		if (!cludings.contains(clude)) {
			cludings.add(clude);
		}
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

	public Set<Cluding> getCluding(Class<? extends Cluding> clazz) {
		Set<Cluding> result = new HashSet<Cluding>();
		for (Cluding c : cludings) {

			if (c.getClass().equals(clazz)) {
				result.add(c);
			}
		}

		return result;
	}

}
