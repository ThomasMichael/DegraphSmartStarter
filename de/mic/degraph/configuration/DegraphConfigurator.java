package de.mic.degraph.configuration;

import static de.mic.degraph.configuration.util.StringUtil.CRLF;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;
import de.mic.degraph.configuration.external.ProcessStarter;
import de.mic.degraph.configuration.types.Cluding;
import de.mic.degraph.configuration.types.Excluding;
import de.mic.degraph.configuration.types.Group;
import de.mic.degraph.configuration.types.Including;
import de.mic.degraph.configuration.types.YedOutput;

public class DegraphConfigurator {

	private static final String DEGRAPH_CONFIG_EXTENSION = ".config";
	private static final String YED_EXTENSION = ".graphml";

	private static final String YED_JAR = "yed.jar";

	private static final String DEGRAPH_JAR = "degraph*.bat";

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button addExcludeButton;

	@FXML
	private TextArea classpathTextArea;

	@FXML
	private TextArea definedGroups;

	@FXML
	private TextArea excludeTextArea;

	@FXML
	private TextField excludeTextfield;

	@FXML
	private TextField filenameTextfield;

	@FXML
	private Button graphmlSaveAs;

	@FXML
	private Button groupButtoon;

	@FXML
	private Button includeButton;

	@FXML
	private TextArea includeTextArea;

	@FXML
	private TextField includeTextfield;

	@FXML
	private Label pathTographml;

	@FXML
	private TextField pathToDegraph;

	@FXML
	private Label pathToDegraphConfig;

	@FXML
	private TextField pathToYed;

	@FXML
	private Button searchClasspath;

	@FXML
	private Button searchYedButton;

	@FXML
	private TextArea groupTextarea;

	@FXML
	private TextField groupTextfield;

	@FXML
	private Button startDegraph;

	private final ConfigDataHolder data = new ConfigDataHolder();

	private boolean notStarted = true;
	// Workingdirectory from User
	private File workingDirectory = null;

	@FXML
	void addGroupAction(ActionEvent event) {
		if (!groupTextfield.getText().isEmpty()) {
			data.addGroup(new Group(groupTextfield.getText(), groupTextarea
					.getText()));
			this.definedGroups.setText(data.getGroups().toString());
		}
	}

	@FXML
	void openYedSearchDialog(ActionEvent event) {

	}

	@FXML
	void openClasspathSearchDialog(ActionEvent event) {

		DirectoryChooser classpathSearcher = new DirectoryChooser();
		classpathSearcher.setTitle("Search Classpath");
		// classpathSearcher.setInitialDirectory(new File);
		File classPathFile = classpathSearcher.showDialog(graphmlSaveAs
				.getScene().getWindow());
		if (classPathFile != null) {
			data.addClassPath(classPathFile);
		}
		setClasspathTextArea();
	}

	@FXML
	void addIncludeAction(ActionEvent event) {
		HandleCludings handleCludings = new HandleCludings() {

			@Override
			public Set<Cluding> getData() {
				return data.getIncludes();
			}

			@Override
			public Cluding addNewCluding(String text) {
				return new Including(text);
			}
		};
		handleCludings.addExcludeAction(event, includeTextfield,
				includeTextArea, data);
	}

	@FXML
	void addExcludeAction(ActionEvent event) {
		HandleCludings handleCludings = new HandleCludings() {

			@Override
			public Set<Cluding> getData() {
				return data.getExcludes();
			}

			@Override
			public Cluding addNewCluding(String text) {
				return new Excluding(text);
			}
		};
		handleCludings.addExcludeAction(event, excludeTextfield,
				excludeTextArea, data);

	}

	@FXML
	void openDegraphSearchDialog(ActionEvent event) {
	}

	@FXML
	void startYedAction(ActionEvent event) {
		ProcessStarter ps = new ProcessStarter();
		String command = "java -jar \"" + this.pathToYed.getText() + "\" "
				+ data.getOutput().getFilePath();
		ps.startProcess(command);
	}

	@FXML
	void openGraphmlSaveAsAction(ActionEvent event) {
		FileChooser fileChooser = createFileChooser("Save as..");
		fileChooser.getExtensionFilters().add(
				new ExtensionFilter("yed", "*.graphml"));
		Window stage = graphmlSaveAs.getScene().getWindow();
		File fileToSave = fileChooser.showSaveDialog(stage);
		File yedConfigFile = new File(fileToSave.getAbsoluteFile()
				+ YED_EXTENSION);
		setWorkingDirectory(yedConfigFile.getParent());
		data.setOutput(new YedOutput(yedConfigFile));
		this.pathTographml.setText(yedConfigFile.getAbsolutePath());
	}

	@FXML
	void openConfigFileAction(ActionEvent event) {
		FileChooser fileChooser = createFileChooser("Save as..");
		fileChooser.getExtensionFilters().add(
				new ExtensionFilter("Degraph Config", "*"
						+ DEGRAPH_CONFIG_EXTENSION));

		Window stage = graphmlSaveAs.getScene().getWindow();
		File fileToSave = fileChooser.showSaveDialog(stage);
		setWorkingDirectory(fileToSave.getParent());
		System.out.println("File: " + fileToSave);
		if (fileToSave != null) {
			data.setDegraphConfig(new File(fileToSave.getAbsoluteFile()
					+ DEGRAPH_CONFIG_EXTENSION));
			this.pathToDegraphConfig.setText(fileToSave.getAbsolutePath()
					+ DEGRAPH_CONFIG_EXTENSION);
		}
	}

	private void setWorkingDirectory(String filepath) {
		if (filepath != null) {
			File file = new File(filepath);
			if (file.isDirectory()) {

				this.workingDirectory = file;
			}
		}

	}

	private void applyWorkingDirectory(FileChooser fileChooser) {
		if (workingDirectory != null) {
			fileChooser.setInitialDirectory(workingDirectory);
		}

	}

	private FileChooser createFileChooser(String title) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(title);
		applyWorkingDirectory(fileChooser);
		return fileChooser;
	}

	@FXML
	void startDegraphAction(ActionEvent event) {
		// create Config
		String message = "Degraph now analyze your code. This may take several minutes. Please wait.";
		DegraphMessage degraphMessage = new DegraphMessage(message);

		File configFile = new ConfigFileBuilder().build(data);
		new DegraphStarter().start(degraphMessage,
				new File(pathToDegraph.getText()), configFile);

		new PopupDegraphResponse().openPopup(degraphMessage);
		// new PopupDegraphResponse().openPopup(message);
	}

	@FXML
	void startDegraphFinder(MouseEvent event) {
		if (notStarted)
			System.out.println("Start");
		new ManageFileFinder(pathToDegraph);
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
		assert addExcludeButton != null : "fx:id=\"addExcludeButton\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert classpathTextArea != null : "fx:id=\"classpathTextArea\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert definedGroups != null : "fx:id=\"definedGroups\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert excludeTextArea != null : "fx:id=\"excludeTextArea\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert excludeTextfield != null : "fx:id=\"excludeTextfield\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert filenameTextfield != null : "fx:id=\"filenameTextfield\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert graphmlSaveAs != null : "fx:id=\"graphmlSaveAs\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert groupButtoon != null : "fx:id=\"groupButtoon\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert includeButton != null : "fx:id=\"includeButton\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert includeTextArea != null : "fx:id=\"includeTextArea\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert includeTextfield != null : "fx:id=\"includeTextfield\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert pathToDegraph != null : "fx:id=\"pathToDegraph\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert pathToDegraphConfig != null : "fx:id=\"pathToDegraphConfig\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert pathToYed != null : "fx:id=\"pathToYed\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert searchClasspath != null : "fx:id=\"searchClasspath\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert searchYedButton != null : "fx:id=\"searchYedButton\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert groupTextarea != null : "fx:id=\"groupTextarea\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert groupTextfield != null : "fx:id=\"groupTextfield\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		assert startDegraph != null : "fx:id=\"startDegraph\" was not injected: check your FXML file 'degraph_configure.fxml'.";
		// Setting path to degraph and yED
		new ManageFileFinder(pathToDegraph).findFileAndSet(DEGRAPH_JAR);
		new ManageFileFinder(this.pathToYed).findFileAndSet(YED_JAR);
	}

}
