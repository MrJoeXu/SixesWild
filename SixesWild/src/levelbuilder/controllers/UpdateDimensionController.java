/**
 * 
 */
package src.levelbuilder.controllers;

import javax.swing.JSlider;
import javax.swing.JTextField;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.Level;

/**
 * @author Tiffany Leung
 * @author Halsey Vandenberg
 *
 */
public class UpdateDimensionController {
	protected Level level;
	protected LevelBuilderWindow application;
	protected JSlider slider;
	/**
	 * 
	 */
	public UpdateDimensionController(LevelBuilderWindow application, Level level, JSlider slider) {
		this.application = application;
		this.level = level;
		this.slider = slider;
	}

}
