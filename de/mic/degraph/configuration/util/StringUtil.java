package de.mic.degraph.configuration.util;

import java.io.File;

/**
 * SomeUtils like linefeed.
 * 
 * @author thomicha
 * 
 */
public final class StringUtil {
	/**
	 * Linefeed with carriage return.
	 */
	public static String CRLF = "\r\n";
	/*
	 * One Tab
	 */
	public static String TAB = "\t";
	/*
	 * Separator for classpaths, depends on OS.
	 */
	public static String CLASSPATHSEPARATOR = File.separator;

}
