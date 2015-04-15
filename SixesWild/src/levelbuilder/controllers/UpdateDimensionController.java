/**
 * 
 */
package src.levelbuilder.controllers;

import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import src.levelbuilder.view.LevelBuilderWindow;
import src.sixeswildgame.world.Level;

/**
 * @author Tiffany Leung
 *
 */
public class UpdateDimensionController implements ChangeListener {
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
	@Override
	public void stateChanged(ChangeEvent arg0) {
		
		
	}
	
	

}
