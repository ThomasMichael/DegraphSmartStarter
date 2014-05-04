package de.mic.degraph.configuration;

import static de.mic.degraph.configuration.util.StringUtil.CRLF;

import java.util.Set;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import de.mic.degraph.configuration.types.Cluding;
import de.mic.degraph.configuration.types.Excluding;

public abstract class HandleCludings {

	void addExcludeAction(ActionEvent event, TextArea field,
			ConfigDataHolder data) {
		if (!field.getText().isEmpty()) {
			data.addCluding(new Excluding(field.getText()));
			setField(field, data);
		}
	}

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
