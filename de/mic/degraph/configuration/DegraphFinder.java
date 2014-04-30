package de.mic.degraph.configuration;

import java.io.File;
import java.io.FileFilter;

/**
 * This class search for degraph in filesystem.
 * 
 * @author thomicha
 * 
 */
public class DegraphFinder {

	private final String degraphName = "Degraph.*.jar";

	public File find(File root) {

		System.out.println("Root: " + root.getPath());
		FileFilter degraphFilter = new FileFilter() {

			@Override
			public boolean accept(File f) {
				return f.isFile() && f.getName().matches(degraphName);
			}
		};
		return search(root, degraphFilter);

	}

	private File search(File current, FileFilter filter) {

		System.out.println(current.getAbsolutePath());
		if (current.isDirectory()) {
			File[] expected = current.listFiles(filter);
			if (expected != null) {

				if (expected.length > 0) {
					// found
					return expected[0];
				} else {
					for (File f : current.listFiles()) {
						search(f, filter);
					}
				}
			}
		}
		return null; // nothing found
	}
}
