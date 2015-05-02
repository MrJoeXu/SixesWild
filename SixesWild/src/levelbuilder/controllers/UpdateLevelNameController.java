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
 * @author Tiffany
 *
 */
public class UpdateLevelNameController implements DocumentListener {
	protected Level level;
	protected LevelBuilderWindow application;
	protected JTextField textField;

	/**
	 * Creates new UpdateLevelNameController with specified application, level,
	 * and textField
	 * 
	 * @param application
	 * @param level
	 * @param textField
	 */
	public UpdateLevelNameController(LevelBuilderWindow application,
			Level level, JTextField textField) {
		this.application = application;
		this.level = level;
		this.textField = textField;
	}

	/**
	 * Updates the title of the custom level
	 */
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		changeLvlNameTitle();
	}

	/**
	 * Updates the title of the custom level
	 */
	@Override
	public void insertUpdate(DocumentEvent arg0) {
		changeLvlNameTitle();
	}
	
	/**
	 * Updates the title of the custom level
	 */
	@Override
	public void removeUpdate(DocumentEvent arg0) {
		changeLvlNameTitle();
	}
	
	/**
	 * Updates the title of the custom level
	 */
	public void changeLvlNameTitle() {
		application.getLbLevelView().getLevelNameLbl()
				.setText("\"" + textField.getText() + "\"");
		if (textField.getText().equals(""))
			application.getLbLevelView().getLevelNameLbl().setText("New Level");
		application.getLbLevelView().getSaveLbl().setText("Unsaved Changes");
	}

}
