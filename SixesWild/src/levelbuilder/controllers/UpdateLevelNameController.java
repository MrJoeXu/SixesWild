/**
 * 
 */
package src.levelbuilder.controllers;

import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.Level;

/**
 * @author Tiffany Leung
 * @author Halsey Vandenberg
 *
 */
public class UpdateLevelNameController implements ActionListener {
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
