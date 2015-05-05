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
public class UpdateOneStarController implements DocumentListener {
	protected Level level;
	protected LevelBuilderWindow application;
	protected JTextField textField;

	/**
	 * Creates new UpdateOneStarController with specified application, level,
	 * and textField
	 * 
	 * @param application
	 * @param level
	 * @param textField
	 */
	public UpdateOneStarController(LevelBuilderWindow application, Level level,
			JTextField textField) {
		this.application = application;
		this.level = level;
		this.textField = textField;
	}

	/**
	 * Sets the one star value threshold
	 */
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		changeOneStarValue();
	}
	
	/**
	 * Sets the one star value threshold
	 */
	@Override
	public void insertUpdate(DocumentEvent arg0) {
		changeOneStarValue();
	}
	
	/**
	 * Sets the one star value threshold
	 */
	@Override
	public void removeUpdate(DocumentEvent arg0) {
		changeOneStarValue();
	}
	
	/**
	 * Sets the one star value threshold
	 */
	public void changeOneStarValue() {
		if (textField.getText().isEmpty()) {
			level.setOneStarScore(0);
		}
		if (textField.getText().matches("^[0-9]+$")) {
			int oneStarValue = Integer.parseInt(textField.getText());
			level.setOneStarScore(oneStarValue);
			// System.out.println(level.getOneStarScore());
		}
		application.getLbLevelView().getSaveLbl().setText("Unsaved Changes");
	}

}
