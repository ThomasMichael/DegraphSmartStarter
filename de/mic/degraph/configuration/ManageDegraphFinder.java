package de.mic.degraph.configuration;

import java.io.File;

import javafx.scene.control.TextField;

public class ManageDegraphFinder {

	private final TextField field;

	public ManageDegraphFinder(TextField degraphPath) {
		this.field = degraphPath;
		setDepgraphFilePath();
	}

	public void setDepgraphFilePath() {

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				DegraphFinder degraphFinder = new DegraphFinder();
				File find = degraphFinder.find(new File(File.separator));
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
