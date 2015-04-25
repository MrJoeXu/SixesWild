package src.levelbuilder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
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
public class UpdateResetBoardController implements ActionListener,
		DocumentListener {
	protected Level level;
	protected LevelBuilderWindow application;
	protected JTextField textField;
	protected JCheckBox checkBox;
	

	/**
	 * @param level
	 * @param application
	 * @param textField
	 */
	public UpdateResetBoardController(LevelBuilderWindow application,
			Level level, JTextField textField, JCheckBox checkBox) {
		this.level = level;
		this.application = application;
		this.textField = textField;
		this.checkBox = checkBox;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		application.getLbLevelView().getResetBoardTextField()
				.setEnabled(checkBox.isSelected());
		
		level.getAllowedSpecialMoves()[1] = checkBox.isSelected(); 
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		changeNumResetBoardMoves();

	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		changeNumResetBoardMoves();

	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		changeNumResetBoardMoves();

	}

	public void changeNumResetBoardMoves() {
		if (textField.getText().isEmpty()) {
			level.setResetBoardMoves(0);
		} 
		
		if (textField.getText().matches("^[0-9]+$")) {
			int numResetBoardMoves = Integer.parseInt(textField.getText());
			level.setResetBoardMoves(numResetBoardMoves);
		}
	}

}
