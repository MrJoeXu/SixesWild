package src.levelbuilder.controllers;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.Level;

/**
 * 
 * @author tleung
 *
 */
public class UpdateThreeStarController implements DocumentListener {
	protected Level level;
	protected LevelBuilderWindow application;
	protected JTextField textField;

	/**
	 * Creates new UpdateThreeStarController with specified application, level,
	 * and textField
	 * 
	 * @param application
	 * @param level
	 * @param textField
	 */
	public UpdateThreeStarController(LevelBuilderWindow application,
			Level level, JTextField textField) {
		this.application = application;
		this.level = level;
		this.textField = textField;
	}

	/**
	 * Sets the three star value threshold
	 */
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		changeThreeStarValue();
	}

	/**
	 * Sets the three star value threshold
	 */
	@Override
	public void insertUpdate(DocumentEvent arg0) {
		changeThreeStarValue();
	}

	/**
	 * Sets the three star value threshold
	 */
	@Override
	public void removeUpdate(DocumentEvent arg0) {
		changeThreeStarValue();
	}

	/**
	 * Sets the three star value threshold
	 */
	public void changeThreeStarValue() {
		if (textField.getText().isEmpty()) {
			level.setThreeStarScore(0);
		}
		if (textField.getText().matches("^[0-9]+$")) {
			int threeStarValue = Integer.parseInt(textField.getText());
			level.setThreeStarScore(threeStarValue);
			// System.out.println(level.getThreeStarScore());
		}
		application.getLbLevelView().getSaveLbl().setText("Unsaved Changes");
	}

}
