package de.mic.degraph.configuration.folderfinder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ScanDirectory {
	private final List<File> directories;
	private boolean acceptInnerClasses;

	public ScanDirectory() {
		directories = new ArrayList<>();
		acceptInnerClasses = true;
	}

	/**
	 * Determines whether inner classes should be collected.
	 * 
	 * @param b
	 *            <code>true</code> to collect inner classes; <code>false</code>
	 *            otherwise.
	 */
	public void acceptInnerClasses(boolean b) {
		acceptInnerClasses = b;
	}

	public void addDirectory(String name) throws IOException {

		File directory = new File(name);

		if (directory.isDirectory() || acceptJarFile(directory)) {
			directories.add(directory);
		} else {
			throw new IOException("Invalid directory or JAR file: " + name);
		}
	}

	public boolean acceptFile(File file) {
		return acceptClassFile(file) || acceptJarFile(file);
	}

	public boolean acceptClassFile(File file) {
		if (!file.isFile()) {
			return false;
		}
		return acceptClassFileName(file.getName());
	}

	public boolean acceptClassFileName(String name) {

		if (!acceptInnerClasses) {
			if (name.toLowerCase().indexOf("$") > 0) {
				return false;
			}
		}

		if (!name.toLowerCase().endsWith(".class")) {
			return false;
		}

		return true;
	}

	public boolean acceptJarFile(File file) {
		return isJar(file) || isZip(file) || isWar(file);
	}

	public Collection<File> extractFiles() {

		Collection<File> files = new ArrayList<File>();

		for (Iterator<File> i = directories.iterator(); i.hasNext();) {
			File directory = i.next();
			collectFiles(directory, files);
		}

		return files;
	}

	public Collection<File> extractFolder() {
		List<File> folder = new ArrayList<File>();
		Collection<File> allFiles = extractFiles();
		for (File f : allFiles) {
			if (f.isDirectory()) {
				folder.add(f);
			}
		}

		return folder;
	}

	private void collectFiles(File directory, Collection<File> files) {

		if (directory.isFile()) {

			addFile(directory, files);

		} else {

			String[] directoryFiles = directory.list();

			for (int i = 0; i < directoryFiles.length; i++) {

				File file = new File(directory, directoryFiles[i]);
				if (acceptFile(file)) {
					addFile(file, files);
				} else if (file.isDirectory()) {
					collectFiles(file, files);
				}
			}
		}
	}

	private void addFile(File f, Collection<File> files) {
		if (!files.contains(f)) {
			files.add(f);
		}
	}

	private boolean isWar(File file) {
		return existsWithExtension(file, ".war");
	}

	private boolean isZip(File file) {
		return existsWithExtension(file, ".zip");
	}

	private boolean isJar(File file) {
		return existsWithExtension(file, ".jar");
	}

	private boolean existsWithExtension(File file, String extension) {
		return file.isFile()
				&& file.getName().toLowerCase().endsWith(extension);
	}
}