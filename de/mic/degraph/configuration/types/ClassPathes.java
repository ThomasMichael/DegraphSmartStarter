package de.mic.degraph.configuration.types;

import static de.mic.degraph.configuration.util.StringUtil.CLASSPATHSEPARATOR;
import static de.mic.degraph.configuration.util.StringUtil.CRLF;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class hold the classpaths which should be analyzed.
 * 
 * 
 */
public class ClassPathes {

	List<File> classPaths = new ArrayList<File>();

	public void addClasspath(File classPath) {
		classPaths.add(classPath);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("classpath = ");
		for (File cp : classPaths) {
			sb.append(cp.getAbsolutePath());
			sb.append(CLASSPATHSEPARATOR);
		}
		sb.append(CRLF);
		return sb.toString();
	}
}
