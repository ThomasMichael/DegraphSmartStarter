package de.mic.degraph.configuration;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class shows the degrpah output in a popup.
 * 
 */
public class PopupDegraphResponse {

	public void openPopup(DegraphMessage degraphMessage) {
		final Button okButton = new Button("Ok");
		okButton.setVisible(false);
		final Text text = new Text();
		text.setText(degraphMessage.getText());
		degraphMessage.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0,
					String arg1, String arg2) {
				System.out.println("Popup: old/new: " + arg1 + "/" + arg2);
				text.setText(arg2);
				okButton.setVisible(true);
			}
		});
		final Stage myDialog = new Stage();
		myDialog.initModality(Modality.APPLICATION_MODAL);
		myDialog.setTitle("Degraph output.");

		okButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				myDialog.close();
			}
		});

		Scene myDialogScene = new Scene(VBoxBuilder.create()
				.children(text, okButton).spacing(30).alignment(Pos.CENTER)
				.padding(new Insets(10)).build());

		myDialog.setScene(myDialogScene);
		myDialog.show();
	}
}
