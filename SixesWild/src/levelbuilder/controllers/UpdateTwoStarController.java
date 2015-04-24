package src.levelbuilder.controllers;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.Level;

public class UpdateTwoStarController implements DocumentListener {
	protected Level level;
	protected LevelBuilderWindow application;
	protected JTextField textField;

	/**
	 * 
	 */
	public UpdateTwoStarController(LevelBuilderWindow application,
			Level level, JTextField textField) {
		this.application = application;
		this.level = level;
		this.textField = textField;
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		changeTwoStarValue();
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		changeTwoStarValue();
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		changeTwoStarValue();
	}

	public void changeTwoStarValue() {
		int twoStarValue = Integer.parseInt(textField.getText());
		level.setTwoStarScore(twoStarValue);
		//System.out.println(level.getTwoStarScore());
	}

}