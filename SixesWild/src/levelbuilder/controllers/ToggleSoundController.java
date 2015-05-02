/**
 * 
 */
package src.levelbuilder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import src.levelbuilder.view.LevelBuilderWindow;

/**
 * @author Halsey
 *
 */
public class ToggleSoundController implements ActionListener {
	
	protected LevelBuilderWindow application;

	/**
	 * Creates new ToggleSoundController with application
	 * @param application
	 */
	public ToggleSoundController(LevelBuilderWindow application) {
		super();
		this.application = application;
	}
	
	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		application.toggleSound();
		if (application.isSoundEnabled()) {
			try {
				application.getMusicClip().loop(Clip.LOOP_CONTINUOUSLY);
			}
			catch (Exception e1) {
			    
			}
		} else
			application.getMusicClip().stop();
	}

}
