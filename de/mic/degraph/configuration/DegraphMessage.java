package de.mic.degraph.configuration;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * This class is for data exchange between Degraph and splash-popup.
 * 
 * @author thomicha
 * 
 */
public class DegraphMessage {

	private StringProperty text;

	public DegraphMessage(String message) {
		setText(message);
	}

	final public void setText(String value) {
		textProperty().set(value);
	}

	final public String getText() {
		return textProperty().get();
	}

	final public StringProperty textProperty() {
		if (text == null) {
			text = new SimpleStringProperty(this, "text");
			text.addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> arg0,
						String arg1, String arg2) {
					System.out.println("old/new: " + arg1 + "/" + arg2);
				}
			});
		}
		return text;
	}
}
