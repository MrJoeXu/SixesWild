/**
 * 
 */
package src.levelbuilder.controllers;

import javax.sound.sampled.FloatControl;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import src.levelbuilder.view.LevelBuilderWindow;

/**
 * @author Halsey
 *
 */
public class AdjustMusicController implements ChangeListener {
	
	protected LevelBuilderWindow application;
	
	/**
	 * Creates new AdjustMusicController with specified application
	 * 
	 * @param application
	 */
	public AdjustMusicController(LevelBuilderWindow application) {
		super();
		this.application = application;
	}
	
	/**
	 * Adjusts the volume of the music
	 */
	@Override
	public void stateChanged(ChangeEvent arg0) {
		FloatControl gainControl = 
			    (FloatControl) application.getMusicClip().getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(application.getSoundVolume()*-10.0f);
	}

}
