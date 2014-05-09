package de.mic.degraph.configuration.folderfinder;

import java.io.File;
import java.util.Collection;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.junit.Test;

public class Finddependcy {

	@Test
	public void test2() throws Exception {
		ScanDirectory fm = new ScanDirectory();
		File folder = new File(
				"C:\\Users\\thomicha\\Programme\\apache-tomcat-7.0.50");
		fm.addDirectory(folder.getAbsolutePath());
		Collection<File> extractFiles = fm.extractFolder();
		for (File o : extractFiles) {
			System.out.println(o.getAbsolutePath());
		}
	}

	@Test
	public void test1() throws Exception {
		ScanDirectory fm = new ScanDirectory();
		File folder = new File(
				"C:\\Users\\thomicha\\Programme\\degraph\\degraph-0.0.4\\lib");
		fm.addDirectory(folder.getAbsolutePath());
		Collection<File> extractFiles = fm.extractFiles();
		for (File o : extractFiles) {
			JarFile f = new JarFile(o);
			Enumeration<JarEntry> entries = f.entries();
			while (entries.hasMoreElements()) {
				JarEntry classOrRessource = entries.nextElement();
				if (!classOrRessource.isDirectory()) {
					// System.out.println("classname: "
					// + classOrRessource.getName());
				} else {
					System.out.println("Directory: "
							+ classOrRessource.getName());
				}
			}
			System.out.println(o.getAbsolutePath());
		}

	}
}
