package de.mic.degraph.configuration;

import static de.mic.degraph.configuration.util.StringUtil.CRLF;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;
import de.mic.degraph.configuration.types.Excluding;
import de.mic.degraph.configuration.types.Group;
import de.mic.degraph.configuration.types.Including;
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

	@FXML
	private Button searchYedButton;

	@FXML
	private TextField degraphPath;

	@FXML
	private TextField pathToYed;

	@FXML
	private Button searchClasspath;

	private final ConfigDataHolder data = new ConfigDataHolder();

	private boolean notStarted = true;

	@FXML
	void addGroupAction(ActionEvent event) {
		validateGroup();
		data.addGroup(new Group(sliceTextfield.getText(), sliceTextarea
				.getText()));
	}

	@FXML
	void openYedSearchDialog(ActionEvent event) {

	}

	@FXML
	void openClasspathSearchDialog(ActionEvent event) {

		DirectoryChooser classpathSearcher = new DirectoryChooser();
		classpathSearcher.setTitle("Search Classpath");
		// classpathSearcher.setInitialDirectory(new File);
		File classPathFile = classpathSearcher.showDialog(filenameSave
				.getScene().getWindow());
		if (classPathFile != null) {
			data.addClassPath(classPathFile);
		}
		setClasspathTextArea();
	}

	@FXML
	void addIncludeAction(ActionEvent event) {
		if (!this.includeTextfield.getText().isEmpty()) {
			data.addCluding(new Including(this.includeTextfield.getText()));
		}
	}

	@FXML
	void addClasspathAction(ActionEvent event) {
		if (!classpathTextfield.getText().isEmpty()) {
			data.addClassPath(new File(classpathTextfield.getText()));
		}
	}

	@FXML
	void addExcludeAction(ActionEvent event) {
		if (!this.includeTextfield.getText().isEmpty()) {
			data.addCluding(new Excluding(this.excludeTextfield.getText()));
		}
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
		FileChooser fileChooser = createFileChooser("Save as..");
		fileChooser.getExtensionFilters().add(
				new ExtensionFilter("yed", "graphml"));
		Window stage = filenameSave.getScene().getWindow();
		File fileToSave = fileChooser.showSaveDialog(stage);
		System.out.println("File: " + fileToSave);
		data.setOutput(new YedOutput(fileToSave));
	}

	private FileChooser createFileChooser(String title) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(title);
		return fileChooser;
	}

	@FXML
	void startDegraphAction(ActionEvent event) {

		System.out.println("Config-File:");
		System.out.println(data);
	}

	@FXML
	void startDegraphFinder(MouseEvent event) {
		if (notStarted)
			System.out.println("Start");
		new ManageDegraphFinder(degraphPath);
		notStarted = false;
	}

	public void setClasspathTextArea() {
		classpathTextArea.clear();
		StringBuilder sb = new StringBuilder();
		for (File f : data.getClassPaths()) {
			sb.append(f.getAbsolutePath());
			sb.append(CRLF);
		}
		classpathTextArea.setText(sb.toString());
	}

	@FXML
	void initialize() {
		assert addClasspathButton != null : "fx:id=\"addClasspathButton\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert addExcludeButton != null : "fx:id=\"addExcludeButton\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert classpathTextArea != null : "fx:id=\"classpathTextArea\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert classpathTextfield != null : "fx:id=\"classpathTextfield\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert definedSlices != null : "fx:id=\"definedSlices\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert degraphPath != null : "fx:id=\"degraphPath\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert excludeTextArea != null : "fx:id=\"excludeTextArea\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert excludeTextfield != null : "fx:id=\"excludeTextfield\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert filenameSave != null : "fx:id=\"filenameSave\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert filenameTextfield != null : "fx:id=\"filenameTextfield\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert groupButtoon != null : "fx:id=\"groupButtoon\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert includeButton != null : "fx:id=\"includeButton\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert includeTextArea != null : "fx:id=\"includeTextArea\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert includeTextfield != null : "fx:id=\"includeTextfield\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert pathToYed != null : "fx:id=\"pathToYed\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert searchClasspath != null : "fx:id=\"searchClasspath\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert searchYedButton != null : "fx:id=\"searchYedButton\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert sliceTextarea != null : "fx:id=\"sliceTextarea\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert sliceTextfield != null : "fx:id=\"sliceTextfield\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert startDegraph != null : "fx:id=\"startDegraph\" was not injected: check your FXML file 'degraph_configure.fxml'.";

		new ManageDegraphFinder(degraphPath);
	}

	void setDegraph(String pathToDegraph) {
		this.degraphPath.setText(pathToDegraph);
	}
}
