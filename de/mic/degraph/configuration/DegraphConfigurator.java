package de.mic.degraph.configuration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;
import de.mic.degraph.configuration.types.Slice;
import de.mic.degraph.configuration.types.YedOutput;

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
	private TextArea definedSlices;

	@FXML
	private TextArea excludeTextArea;

	@FXML
	private TextField excludeTextfield;

	@FXML
	private Button filenameSave;

	@FXML
	private TextField filenameTextfield;

	@FXML
	private Button groupButtoon;

	@FXML
	private Button includeButton;

	@FXML
	private TextArea includeTextArea;

	@FXML
	private TextField includeTextfield;

	@FXML
	private TextArea sliceTextarea;

	@FXML
	private TextField sliceTextfield;

	@FXML
	private Button startDegraph;

	private final ConfigDataHolder data = new ConfigDataHolder();

	@FXML
	void addGroupAction(ActionEvent event) {
		validateGroup();
		data.addGroup(new Slice(sliceTextfield.getText(), sliceTextarea
				.getText()));
	}

	@FXML
	void addIncludeAction(ActionEvent event) {
	}

	@FXML
	void addClasspathAction(ActionEvent event) {
		if (!classpathTextfield.getText().isEmpty()) {
			data.addClassPath(new File(classpathTextfield.getText()));
		}
	}

	@FXML
	void addExcludeAction(ActionEvent event) {
	}

	private void validateGroup() {
		if (sliceTextfield != null && !sliceTextfield.getText().isEmpty()) {

		} else {

		}

		if (sliceTextarea != null && sliceTextarea.getText().isEmpty()) {

		} else {

		}
	}

	@FXML
	void openDegraphSearchDialog(ActionEvent event) {
	}

	@FXML
	void saveAsAction(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save as..");
		fileChooser.getExtensionFilters().add(
				new ExtensionFilter("yed", "graphml"));
		Window stage = filenameSave.getScene().getWindow();
		File fileToSave = fileChooser.showSaveDialog(stage);
		System.out.println("File: " + fileToSave);
		data.setOutput(new YedOutput(fileToSave));
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
		assert definedSlices != null : "fx:id=\"definedSlices\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert excludeTextArea != null : "fx:id=\"excludeTextArea\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert excludeTextfield != null : "fx:id=\"excludeTextfield\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert filenameSave != null : "fx:id=\"filenameSave\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert filenameTextfield != null : "fx:id=\"filenameTextfield\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert groupButtoon != null : "fx:id=\"groupButtoon\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert includeButton != null : "fx:id=\"includeButton\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert includeTextArea != null : "fx:id=\"includeTextArea\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert includeTextfield != null : "fx:id=\"includeTextfield\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert sliceTextarea != null : "fx:id=\"sliceTextarea\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert sliceTextfield != null : "fx:id=\"sliceTextfield\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert startDegraph != null : "fx:id=\"startDegraph\" was not injected: check your FXML file 'degraph_configure.fxml'.";

	}

}
