/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.Level;

/**
 * @author Tiffany Leung
 * @author Halsey Vandenberg
 *
 */
public class ToggleSpecialMovesController implements ActionListener {
	protected Level level;
	protected LevelBuilderWindow application;
	protected JCheckBox checkBox;
	
	/**
	 * 
	 */
	public ToggleSpecialMovesController(LevelBuilderWindow application, Level level, JCheckBox checkBox) {
		this.application = application;
		this.level = level;
		this.checkBox = checkBox;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
