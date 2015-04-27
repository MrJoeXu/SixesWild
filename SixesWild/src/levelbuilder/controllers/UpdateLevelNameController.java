/**
 * 
 */
package src.levelbuilder.controllers;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionListener;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.Level;

/**
 * 
 * @author tleung
 *
 */
public class UpdateLevelNameController implements DocumentListener {
	protected Level level;
	protected LevelBuilderWindow application;
	protected JTextField textField;
	
	/**
	 * 
	 */
	public UpdateLevelNameController(LevelBuilderWindow application, Level level, JTextField textField) {
		this.application = application;
		this.level = level;
		this.textField = textField;
	}


	@Override
	public void changedUpdate(DocumentEvent arg0) {
		changeLvlNameTitle();
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		changeLvlNameTitle();
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		changeLvlNameTitle();
	}
	
	public void changeLvlNameTitle() {
		application.getLbLevelView().getLevelNameLbl().setText("\"" + textField.getText() + "\"");
		if (textField.getText().equals(""))
			application.getLbLevelView().getLevelNameLbl().setText("Level Name");
	}

}
