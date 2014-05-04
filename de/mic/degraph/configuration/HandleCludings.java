package de.mic.degraph.configuration;

import static de.mic.degraph.configuration.util.StringUtil.CRLF;

import java.util.Set;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import de.mic.degraph.configuration.types.Cluding;

public abstract class HandleCludings {

	void addExcludeAction(ActionEvent event, TextField field, TextArea area,
			ConfigDataHolder data) {
		if (!field.getText().isEmpty()) {
			data.addCluding(addNewCluding(field.getText()));
			setField(area, data);
		}
	}

	public abstract Cluding addNewCluding(String text);

	private void setField(TextArea field, ConfigDataHolder data) {
		field.clear();
		StringBuilder sb = new StringBuilder();
		for (Cluding i : getData()) {
			sb.append(i.toString());
			sb.append(CRLF);
		}

		field.setText(sb.toString());
	}

	public abstract Set<Cluding> getData();
}
