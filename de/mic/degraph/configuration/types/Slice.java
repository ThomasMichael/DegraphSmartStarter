package de.mic.degraph.configuration.types;

import static de.mic.degraph.configuration.util.StringUtil.CRLF;
import static de.mic.degraph.configuration.util.StringUtil.TAB;

public class Slice {

	private final String groupName;
	private final String content;

	public Slice(String groupName, String content) {
		super();
		this.groupName = groupName;
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(groupName);
		sb.append(" = {");
		sb.append(CRLF);
		sb.append(TAB);
		sb.append(content);
		sb.append(CRLF);
		sb.append("}");
		sb.append(CRLF);
		return sb.toString();
	}
}
