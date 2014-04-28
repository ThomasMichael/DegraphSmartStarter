package de.mic.degraph.configuration;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DegraphConfigurator {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button addClasspathButton;

	@FXML
	private Button addExcludeButton;

	@FXML
	private TextArea classpathTextArea;

	@FXML
	private TextField classpathTextfield;

	@FXML
	private TextArea excludeTextArea;

	@FXML
	private TextField excludeTextfield;

	@FXML
	private Button filenameSave;

	@FXML
	private TextField filenameTextfield;

	@FXML
	private TextArea includeTextarea;

	@FXML
	private Button sliceButtoon;

	@FXML
	private TextArea sliceTextarea;

	@FXML
	private TextField sliceTextfield;

	@FXML
	private Button startDegraph;

	@FXML
	void addClasspathAction(ActionEvent event) {
	}

	@FXML
	void addExcludeAction(ActionEvent event) {
	}

	@FXML
	void addSliceAction(ActionEvent event) {
	}

	@FXML
	void saveAsAction(ActionEvent event) {
	}

	@FXML
	void startDegraphAction(ActionEvent event) {
	}

	@FXML
	void initialize() {
		assert addClasspathButton != null : "fx:id=\"addClasspathButton\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert addExcludeButton != null : "fx:id=\"addExcludeButton\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert classpathTextArea != null : "fx:id=\"classpathTextArea\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert classpathTextfield != null : "fx:id=\"classpathTextfield\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert excludeTextArea != null : "fx:id=\"excludeTextArea\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert excludeTextfield != null : "fx:id=\"excludeTextfield\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert filenameSave != null : "fx:id=\"filenameSave\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert filenameTextfield != null : "fx:id=\"filenameTextfield\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert includeTextarea != null : "fx:id=\"includeTextarea\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert sliceButtoon != null : "fx:id=\"sliceButtoon\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert sliceTextarea != null : "fx:id=\"sliceTextarea\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert sliceTextfield != null : "fx:id=\"sliceTextfield\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert startDegraph != null : "fx:id=\"startDegraph\" was not injected: check your FXML file 'degraph_configure.fxml'.";

	}

}
