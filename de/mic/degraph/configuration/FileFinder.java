package de.mic.degraph.configuration;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * This class search for degraph in filesystem.
 * 
 * @author thomicha
 * 
 */
public class FileFinder {

	private boolean reverse;

	public File find(File root, final String searchFileName) {

		FileFilter degraphFilter = new FileFilter() {

			@Override
			public boolean accept(File f) {
				return f.isFile() && f.getName().matches(searchFileName);
			}
		};
		return search(root, degraphFilter);

	}

	private File search(File current, FileFilter filter) {

		if (current.isDirectory()) {
			File[] expected = current.listFiles(filter);
			if (expected != null) {

				if (expected.length > 0) {
					// found
					return expected[0];
				} else {
					for (File f : iterateOver(current)) {
						File found = search(f, filter);
						if (found != null) {
							return found;
						}
					}
				}
			}
		}
		return null; // nothing found
	}

	/**
	 * Seaching Degraph from behind.
	 * 
	 * @param reverse
	 */
	public void setReverse(boolean reverse) {
		this.reverse = reverse;
	}

	private Collection<File> iterateOver(File current) {
		List<File> fileList = Arrays.asList(current.listFiles());
		if (reverse) {
			Collections.reverse(fileList);
		}
		return fileList;
	}
}
