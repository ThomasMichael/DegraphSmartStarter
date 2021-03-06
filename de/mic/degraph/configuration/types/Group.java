package de.mic.degraph.configuration.types;

import static de.mic.degraph.configuration.util.StringUtil.CRLF;

public class Group {

	private final String groupName;
	private final String content;

	public Group(String groupName, String content) {
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
		sb.append(content);
		sb.append(CRLF);
		sb.append("}");
		sb.append(CRLF);
		return sb.toString();
	}
}
