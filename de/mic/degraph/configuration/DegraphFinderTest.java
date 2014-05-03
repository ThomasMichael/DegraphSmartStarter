package de.mic.degraph.configuration;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Test;

public class DegraphFinderTest {

	@Test
	public void performanceFinder() {
		long start = System.currentTimeMillis();
		FileFinder degraphFinder = new FileFinder();
		File find = degraphFinder
				.find(new File(File.separator), "Degraph*.jar");
		assertNotNull(find);
		long stop = System.currentTimeMillis() - start;
		System.out.println("Dauer normal:" + stop / 1000);
	}

	@Test
	public void performanceFinderReverse() {
		long start = System.currentTimeMillis();
		FileFinder degraphFinder = new FileFinder();
		degraphFinder.setReverse(true);
		File find = degraphFinder
				.find(new File(File.separator), "Degraph*.jar");
		assertNotNull(find);
		long stop = System.currentTimeMillis() - start;
		System.out.println("Dauer reverse:" + stop / 1000);
	}

	@Test
	public void performanceFinderThread() throws InterruptedException {
		long start = System.currentTimeMillis();

		final FileWrapper found = new FileWrapper();
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				FileFinder degraphFinder = new FileFinder();
				File find = degraphFinder.find(new File(File.separator),
						"Degraph*.jar");
				found.setFile(find);
			}
		};
		Thread t1 = new Thread(runnable);
		t1.start();

		Runnable reverse = new Runnable() {

			@Override
			public void run() {
				FileFinder degraphFinder = new FileFinder();
				degraphFinder.setReverse(true);
				File find = degraphFinder.find(new File(File.separator),
						"Degraph*.jar");
				found.setFile(find);
			}
		};
		Thread t2 = new Thread(reverse);
		t2.start();

		while (true) {
			if (found.getFile() == null) {
				Thread.sleep(500);
			} else {
				if (t2.isAlive()) {
					t2.interrupt();
				}
				if (t1.isAlive()) {
					t1.interrupt();
				}
				break;
			}
		}
		assertNotNull(found.getFile());

		long stop = System.currentTimeMillis() - start;
		System.out.println("Dauer Thread:" + stop / 1000);
	}

	class FileWrapper {
		File file;

		void setFile(File aFile) {
			file = aFile;
		}

		File getFile() {
			return file;
		}
	}
}
