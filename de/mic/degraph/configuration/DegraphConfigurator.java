package de.mic.degraph.configuration;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DegraphConfigurator {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button startDegraph;

	@FXML
	void startDegraph(ActionEvent event) {
	}

	@FXML
	void initialize() {
		assert startDegraph != null : "fx:id=\"startDegraph\" was not injected: check your FXML file 'degraph_configure.fxml'.";

	}

}
