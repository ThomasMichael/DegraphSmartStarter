package de.mic.degraph.configuration;

import java.io.File;

import javafx.scene.control.TextField;

public class ManageFileFinder {

	private final TextField field;

	public ManageFileFinder(TextField fieldForPath) {
		this.field = fieldForPath;
	}

	public void findFileAndSet(final String filename) {

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				FileFinder finder = new FileFinder();
				File find = finder.find(new File(File.separator), filename);
				if (field == null || find == null) {
					System.out.println("Nothing found! Searching for: "
							+ filename);
				} else {
					field.setText(find.getAbsolutePath());
				}
			}
		};
		new Thread(runnable).start();
	}
}
