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
	 * Creates new UpdateSecondsController with specified application, level,
	 * and textField
	 * 
	 * @param application
	 * @param level
	 * @param textField
	 */
	public UpdateSecondsController(LevelBuilderWindow application, Level level,
			JTextField textField) {
		this.application = application;
		this.level = level;
		this.textField = textField;
	}

	/**
	 * Sets the seconds of the count down time
	 */
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		changeSecondsValue();
	}

	/**
	 * Sets the seconds of the count down time
	 */
	@Override
	public void insertUpdate(DocumentEvent arg0) {
		changeSecondsValue();
	}

	/**
	 * Sets the seconds of the count down time
	 */
	@Override
	public void removeUpdate(DocumentEvent arg0) {
		changeSecondsValue();
	}

	/**
	 * Sets the seconds of the count down time
	 */
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