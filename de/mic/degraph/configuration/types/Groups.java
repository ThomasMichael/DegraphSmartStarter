package de.mic.degraph.configuration.types;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds all defined slices/groups.
 * 
 * @author thomicha
 * 
 */
public class Groups {
	List<Group> groups = new ArrayList<>();

	public void addGroup(Group group) {
		groups.add(group);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Group group : groups) {
			sb.append(group.toString());
			sb.append("\n\r");
		}
		return sb.toString();
	}

}
