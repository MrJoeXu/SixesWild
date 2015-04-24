package src.levelbuilder.controllers;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.Level;

public class UpdateThreeStarController implements DocumentListener {
	protected Level level;
	protected LevelBuilderWindow application;
	protected JTextField textField;

	/**
	 * 
	 */
	public UpdateThreeStarController(LevelBuilderWindow application,
			Level level, JTextField textField) {
		this.application = application;
		this.level = level;
		this.textField = textField;
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		changeThreeStarValue();
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		changeThreeStarValue();
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		changeThreeStarValue();
	}

	public void changeThreeStarValue() {
		int threeStarValue = Integer.parseInt(textField.getText());
		level.setThreeStarScore(threeStarValue);
		//System.out.println(level.getThreeStarScore());
	}

}