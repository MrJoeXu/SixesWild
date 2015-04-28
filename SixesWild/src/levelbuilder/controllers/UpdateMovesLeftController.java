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
public class UpdateMovesLeftController implements DocumentListener {
	protected Level level;
	protected LevelBuilderWindow application;
	protected JTextField textField;

	/**
	 * @param level
	 * @param application
	 * @param textField
	 */
	public UpdateMovesLeftController(LevelBuilderWindow application,
			Level level, JTextField textField) {
		this.level = level;
		this.application = application;
		this.textField = textField;
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		changeMovesLeftMoves();

	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		changeMovesLeftMoves();

	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		changeMovesLeftMoves();

	}

	public void changeMovesLeftMoves() {
		if (textField.getText().isEmpty()) {
			level.setMovesLeft(0);
		}
		if (textField.getText().matches("^[0-9]+$")) {
			int movesLeft = Integer.parseInt(textField.getText());
			level.setMovesLeft(movesLeft);
		}
		application.getLbLevelView().getSaveLbl().setText("Unsaved Changes");
	}

}