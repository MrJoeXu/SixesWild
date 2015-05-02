package src.levelbuilder.controllers;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.Level;

/**
 * 
 * @author Tiffany
 *
 */
public class UpdateTwoStarController implements DocumentListener {
	protected Level level;
	protected LevelBuilderWindow application;
	protected JTextField textField;

	/**
	 * Creates new UpdateTwoStarController with specified application, level,
	 * and textField
	 * 
	 * @param application
	 * @param level
	 * @param textField
	 */
	public UpdateTwoStarController(LevelBuilderWindow application, Level level,
			JTextField textField) {
		this.application = application;
		this.level = level;
		this.textField = textField;
	}

	/**
	 * Sets the two star value threshold
	 */
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		changeTwoStarValue();
	}

	/**
	 * Sets the two star value threshold
	 */
	@Override
	public void insertUpdate(DocumentEvent arg0) {
		changeTwoStarValue();
	}

	/**
	 * Sets the two star value threshold
	 */
	@Override
	public void removeUpdate(DocumentEvent arg0) {
		changeTwoStarValue();
	}

	/**
	 * Sets the two star value threshold
	 */
	public void changeTwoStarValue() {
		if (textField.getText().isEmpty()) {
			level.setTwoStarScore(0);
		}
		if (textField.getText().matches("^[0-9]+$")) {
			int twoStarValue = Integer.parseInt(textField.getText());
			level.setTwoStarScore(twoStarValue);
			// System.out.println(level.getTwoStarScore());
		}

		application.getLbLevelView().getSaveLbl().setText("Unsaved Changes");
	}

}