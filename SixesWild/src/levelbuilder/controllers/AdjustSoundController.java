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
public class AdjustSoundController implements ChangeListener {
	
	protected LevelBuilderWindow application;
	
	/**
	 * @param application
	 */
	public AdjustSoundController(LevelBuilderWindow application) {
		super();
		this.application = application;
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		FloatControl gainControl = 
			    (FloatControl) application.getMusicClip().getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(application.getSoundVolume()*-10.0f);
	}

}
