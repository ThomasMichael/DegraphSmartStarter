package de.mic.degraph.configuration;

import java.io.File;

import javafx.scene.control.TextField;

public class ManageFileFinder {

	private final TextField field;

	public ManageFileFinder(TextField fieldForPath) {
		this.field = fieldForPath;
		setDepgraphFilePath();
	}

	public void setDepgraphFilePath() {

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				FileFinder degraphFinder = new FileFinder();
				File find = degraphFinder.find(new File(File.separator),
						"Degraph*.jar");
				if (field == null) {
					System.out.println("Feld ist null!");
				} else {
					field.setText(find.getAbsolutePath());
				}
			}
		};
		new Thread(runnable).start();
	}
}
