package src.levelbuilder.controllers;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.Level;


public class UpdateSecondsController implements DocumentListener {
	protected Level level;
	protected LevelBuilderWindow application;
	protected JTextField textField;

	/**
	 * 
	 */
	public UpdateSecondsController(LevelBuilderWindow application,
			Level level, JTextField textField) {
		this.application = application;
		this.level = level;
		this.textField = textField;
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		changeSecondsValue();
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		changeSecondsValue();
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		changeSecondsValue();
	}

	public void changeSecondsValue() {
		if (textField.getText().isEmpty()) {
			level.setSeconds(0);
		}
		if (textField.getText().matches("^[0-9]+$")) {
			int seconds = Integer.parseInt(textField.getText());
			level.setSeconds(seconds);
			// System.out.println(level.getThreeStarScore());
		}
		application.getLbLevelView().getSaveLbl().setText("Unsaved Changes");
	}

}