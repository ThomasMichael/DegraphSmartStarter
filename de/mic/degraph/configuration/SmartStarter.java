package de.mic.degraph.configuration;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SmartStarter extends Application {

	@FXML
	DegraphConfigurator control;

	@Override
	public void start(Stage stage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource(
				"degraph_configure.fxml"));

		Scene scene = new Scene(root, 300, 275);

		stage.setTitle("FXML Welcome");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
