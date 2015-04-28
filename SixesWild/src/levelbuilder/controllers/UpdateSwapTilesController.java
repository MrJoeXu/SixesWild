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
public class UpdateSwapTilesController implements ActionListener,
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
	public UpdateSwapTilesController(LevelBuilderWindow application,
			Level level, JTextField textField, JCheckBox checkBox) {
		this.level = level;
		this.application = application;
		this.textField = textField;
		this.checkBox = checkBox;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		application.getLbLevelView().getSwapTilesTextField()
				.setEnabled(checkBox.isSelected());

		level.getAllowedSpecialMoves()[1] = checkBox.isSelected();

		application.getLbLevelView().getSaveLbl().setText("Unsaved Changes");

	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		changeNumSwapTilesMoves();

	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		changeNumSwapTilesMoves();

	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		changeNumSwapTilesMoves();

	}

	public void changeNumSwapTilesMoves() {
		if (textField.getText().isEmpty()) {
			level.setSwapTwoTilesMoves(0);
		} 
		if (textField.getText().matches("^[0-9]+$")) {
			int numSwapTilesMoves = Integer.parseInt(textField.getText());
			level.setSwapTwoTilesMoves(numSwapTilesMoves);
		}
		application.getLbLevelView().getSaveLbl().setText("Unsaved Changes");
	}

}