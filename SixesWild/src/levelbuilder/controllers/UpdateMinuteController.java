/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class UpdateMinuteController implements DocumentListener {
	protected Level level;
	protected LevelBuilderWindow application;
	protected JTextField textField;

	/**
	 * 
	 */
	public UpdateMinuteController(LevelBuilderWindow application,
			Level level, JTextField textField) {
		this.application = application;
		this.level = level;
		this.textField = textField;
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		changeMinutesValue();
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		changeMinutesValue();
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		changeMinutesValue();
	}

	public void changeMinutesValue() {
		if (textField.getText().isEmpty()) {
			level.setMinutes(0);
			//System.out.println(level.getMinutes());
		}
		if (textField.getText().matches("^[0-9]+$")) {
			int minutes = Integer.parseInt(textField.getText());
			level.setMinutes(minutes);
			//System.out.println(level.getMinutes());
		}
	}

}